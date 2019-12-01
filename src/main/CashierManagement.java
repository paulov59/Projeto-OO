package main;

import people.*;
import products.*;

import java.io.*;
import java.util.*;

public class CashierManagement {

    private ArrayList<Sale> sales = new ArrayList<Sale>();
    private Scanner input = new Scanner(System.in);
    private double currentMoney = 0;

    public boolean validateCpf(String cpf) {
        return cpf.matches("[0-9]*");
    }

    public CashierManagement() {

    }

    public boolean openCashier() {
        System.out.print("Nome de usuário: ");
        String user = input.nextLine();

        System.out.print("Senha: ");
        String password = input.nextLine();

        while (!user.equals("admin") || !password.equals("admin")) {
            System.out.println("Usuário ou senha invalidos!");

            System.out.print("Nome de usuário: ");
            user = input.nextLine();

            System.out.print("Senha: ");
            password = input.nextLine();
        }

        boolean flag = false;
        while (!flag) {
            try {
                currentMoney = 0;
                flag = true;
                System.out.print("Valor inicial do caixa: R$ ");
                currentMoney = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Por favor, insira um valor válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        return true;
    }

    public boolean closeCashier() {
        System.out.print("Nome de usuário: ");
        String user = input.nextLine();

        System.out.print("Senha: ");
        String password = input.nextLine();

        while (!user.equals("admin") || !password.equals("admin")) {
            System.out.println("Usuário ou senha invalidos!");
            System.out.print("Nome de usuário: ");
            user = input.nextLine();

            System.out.print("Senha: ");
            password = input.nextLine();
        }

        System.out.printf("Valor final do caixa: R$ %.2f\n", this.currentMoney);

        return false;
    }

    public void toSell(ArrayList<Product> products, ArrayList<Client> clients, ArrayList<Employee> employees) {
        String option;
        boolean flag;
        Employee employee = null;
        Client client = null;

        if (products.isEmpty()) {
            System.out.println("Não há produtos cadastrados!");
            return;
        }

        if (!clients.isEmpty()) {
            System.out.print("Identificar o cliente? (s/n) ");
            option = input.nextLine();

            while (!option.equals("s") && !option.equals("n") && !option.equals("S") && !option.equals("N")) {
                System.out.println("Opção Inválida!");
                System.out.print("Identificar o cliente? (s/n) ");
                option = input.nextLine();
            }

            if (option.equals("s") || option.equals("S")) {
                String cpf = null;
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Digite o CPF do cliente: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                    ClientManagement clientManage = new ClientManagement();
                    client = clientManage.findClient(cpf, clients);
                    if (client != null) {
                        client.setSales();
                    } else {
                        System.out.println("Cliente não encontrado!");
                        flag = false;
                    }
                }
            }
        }

        if (!employees.isEmpty()) {
            String cpf = null;
            flag = false;
            while (!flag) {
                try {
                    flag = true;
                    System.out.print("CPF do vendedor: ");
                    cpf = input.nextLine();
                    if (!validateCpf(cpf) || cpf.length() != 11) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, insira um CPF válido");
                    flag = false;
                }
                EmployeeManagement employeeManage = new EmployeeManagement();
                employee = employeeManage.findEmployee(cpf, employees);
                if (employee != null) {
                    employee.setSales();
                } else {
                    System.out.println("Vendedor não encontrado!");
                    flag = false;
                }
            }
        }

        int nSale = 1;

        if (!sales.isEmpty()) {
            nSale = 1 + (sales.get(sales.size()-1)).getSale();
        }

        Sale sale = new Sale(nSale, client, employee);

        int code = 0;
        flag = false;
        Product product = null;

        while (!flag) {
            try {
                flag = true;
                System.out.print("Digite o código do produto: ");
                code = input.nextInt();
                for (Product aux: products) {
                    if (aux.getCode() == code) {
                        product = aux;
                        break;
                    }
                }
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                    throw new Exception("Produto não encontrado");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira um código válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        sale.setProduct(product);
        if( product instanceof Merchandise ) {
            int amount = ((Merchandise) product).getAmount();
            products.remove(product);
            ((Merchandise) product).setAmount(amount-1);
            products.add(product);
        }

        while (true) {
            System.out.print("Deseja adicionar mais produtos? (s/n) ");
            option = input.nextLine();
            while (!option.equals("s") && !option.equals("n") && !option.equals("S") && !option.equals("N")) {
                System.out.println("Opção Inválida!");
                System.out.print("Deseja adicionar mais produtos? (s/n) ");
                option = input.nextLine();
            }
            if (option.equals("s") || option.equals("S")) {

                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Digite o código do produto: ");
                        code = input.nextInt();
                        product = null;
                        for (Product aux: products) {
                            if (aux.getCode() == code) {
                                product = aux;
                                break;
                            }
                        }
                        if (product == null) {
                            System.out.println("Produto não encontrado!");
                            throw new Exception("Produto não encontrado");
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um código válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                sale.setProduct(product);
                if( product instanceof Merchandise ) {
                    int amount = ((Merchandise) product).getAmount();
                    products.remove(product);
                    ((Merchandise) product).setAmount(amount-1);
                    products.add(product);
                }
            } else {
                break;
            }
        }

        double finalPrice = sale.getPrice();
        sales.add(sale);

        System.out.printf("Total: R$ %.2f\n", finalPrice);

        currentMoney += finalPrice;

    }

    public void cancelSale(ArrayList<Product> products) {
        int nSale = 0;
        boolean flag = false;

        while (!flag) {
            try {
                flag = true;
                System.out.print("Nota fiscal: ");
                nSale = input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, insira um código válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        Sale toCancel = null;
        for (Sale sale:sales) {
            if (sale.getSale() == nSale) {
                toCancel = sale;
                break;
            }
        }

        if (toCancel != null) {

            currentMoney -= toCancel.getPrice();
            ArrayList<Product> p = toCancel.getProducts();
            sales.remove(toCancel);
            Product product;
            for (Product aux: p) {
                if (aux instanceof Merchandise) {
                    product = aux;
                    int amount = ((Merchandise) product).getAmount();
                    products.remove(product);
                    ((Merchandise) product).setAmount(amount + 1);
                    products.add(product);
                }
            }
            toCancel.employee.removeSale();
            toCancel.client.removeSale();
            System.out.println("Venda cancelada");
        } else {
            System.out.println("Venda não encontrada");
        }

    }

    public void findSale() {
        int nSale = 0;
        boolean flag = false;

        while (!flag) {
            try {
                flag = true;
                System.out.print("Nota fiscal: ");
                nSale = input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, insira um código válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        Sale sale = null;
        for (Sale aux:sales) {
           if (aux.getSale() == nSale) {
               sale = aux;
               break;
           }
        }

        if (sale == null) {
            System.out.println("Venda não encontrada");
        } else {
            System.out.println(sale);
            for (Product product: sale.products) {
                if (product instanceof Merchandise) {
                    System.out.printf("Código: %d - %s: R$ %.2f\n", product.getCode(), product.getName(), product.getPrice());
                } else {
                    System.out.printf("Código: %d - %s: R$ %.2f\n", product.getCode(), product.getName(), product.getPrice());
                }
            }
        }
    }

    public void salesReport() {
        if (sales.isEmpty()) {
            System.out.println("Sem vendas registradas");
        } else {
            for (Sale sale:sales) {
                System.out.println(sale);
            }
        }
    }

}
