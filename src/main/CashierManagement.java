package main;

import people.*;
import products.*;
import java.util.*;

public class CashierManagement {

    static ArrayList<Sale> sales = new ArrayList<Sale>();
    Scanner input = new Scanner(System.in);
    static double currentMoney;

    public CashierManagement() {
        this.currentMoney = 0;
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

        System.out.print("Valor inicial do caixa: R$ ");
        currentMoney = input.nextDouble();
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

    public void toSell(ArrayList<Product> products, ArrayList<Client> clients) {
        Client client;
        System.out.print("Identificar o cliente? (s/n) ");
        String option = input.nextLine();
        while (!option.equals("s") && !option.equals("n")) {
            System.out.println("Opção Inválida!");
            System.out.print("Identificar o cliente? (s/n) ");
            option = input.nextLine();
        }
        if (option.equals("s")) {
            System.out.print("Digite o CPF do cliente: ");
            long cpf = input.nextLong();
            ClientManagement clientManage = null;
            client = clientManage.findClient(cpf, clients);
            client.setSales();
        }else {
            client = null;
        }
        int nSale = 1;

        if (!sales.isEmpty()) {
            nSale = 1 + (sales.get(sales.size()-1)).getSale();
        }

        Sale sale = new Sale(nSale, client);

        System.out.print("Digite o código do produto: ");
        int code = input.nextInt();
        Product product = null;
        for (Product aux: products) {
            if (aux.getCode() == code) {
                product = aux;
                break;
            }
        }

        if (product == null) {
            System.out.println("Produto não encontrado!");
        } else {
            sale.setProduct(product);
            if( product instanceof Merchandise ) {
                int amount = ((Merchandise) product).getAmount();
                products.remove(product);
                ((Merchandise) product).setAmount(amount-1);
                products.add(product);
            }
        }

        input.nextLine();
        while (true) {
            System.out.print("Deseja adicionar mais produtos? (s/n) ");
            option = input.nextLine();
            while (!option.equals("s") && !option.equals("n")) {
                System.out.println("Opção Inválida!");
                System.out.print("Deseja adicionar mais produtos? (s/n) ");
                option = input.nextLine();
            }
            if (option.equals("s")) {
                System.out.print("Digite o código do produto: ");
                code = input.nextInt();
                for (Product aux: products) {
                    if (aux.getCode() == code) {
                        product = aux;
                        break;
                    }
                }
                sale.setProduct(product);
                if( product instanceof Merchandise ) {
                    int amount = ((Merchandise) product).getAmount();
                    products.remove(product);
                    ((Merchandise) product).setAmount(amount-1);
                    products.add(product);
                }
            }else {
                break;
            }
        }

        double finalPrice = sale.getPrice();
        sales.add(sale);

        System.out.printf("Total: R$ %.2f\n", finalPrice);

        currentMoney += finalPrice;

    }

    public void cancelSale(ArrayList<Product> products) {
        System.out.print("Nota fiscal: ");
        int nSale = input.nextInt();
        Sale toCancel = null;
        for (Sale sale:sales) {
            if (sale.getSale() == nSale) {
                toCancel = sale;
                break;
            }
        }

        currentMoney -= toCancel.getPrice();
        ArrayList<Product> p = toCancel.getProducts();
        System.out.println(p);
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

    }

    public void findSale() {
        System.out.print("Nota fiscal: ");
        int nSale = input.nextInt();
        for (Sale sale:sales) {
           if (sale.getSale() == nSale) {
               System.out.println(sale);
               break;
           }
        }
    }

    public void salesReport() {
        for (Sale sale:sales) {
            System.out.println(sale);
        }
    }

}
