package main;

import products.*;
import people.*;

import java.util.*;
import java.lang.*;

public class StoreManager {

    private Scanner input = new Scanner(System.in);
    private boolean isOpen = false;
    private CashierManagement cashier = new CashierManagement();
    private ClientManagement clientManagement = new ClientManagement();
    private EmployeeManagement employeeManagement = new EmployeeManagement();
    private StockManagement stock = new StockManagement();

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();


    public void run() {
        clear();
        System.out.println("Bem vindo ao Store Manager!");
        System.out.println("Selecione uma das opções no menu...");
        int option = menu();
        do {
            if (option == 5) {
                break;
            }
            clear();
            option = menu();
        } while (option != 5);

        System.out.println("\nObrigado por usar o Store Manager!\n");

    }

    private int menu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Gerenciar caixa");
        System.out.println("\t[2] - Gerenciar clientes");
        System.out.println("\t[3] - Gerenciar funcionários");
        System.out.println("\t[4] - Gerenciar estoque");
        System.out.println("\t[5] - Sair");

        int option = 0;
        boolean flag = false;

        while (!flag) {
            try {
                option = 0;
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 5) {
                    throw new Exception("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        switch (option) {
            case 1:
                cashierManagement();
                break;
            case 2:
                clientManagement();
                break;
            case 3:
                employeeManagement();
                break;
            case 4:
                stockManagement();
                break;
            default:
                break;
        }
        return option;
    }

    private void cashierManagement() {
        clear();
        if (isOpen) {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Realizar venda");
            System.out.println("\t[2] - Cancelar venda");
            System.out.println("\t[3] - Buscar venda");
            System.out.println("\t[4] - Relatório de vendas");
            System.out.println("\t[5] - Fechar caixa");
            System.out.println("\t[6] - Voltar");

            int option = 0;
            boolean flag = false;

            while (!flag) {
                try {
                    option = 0;
                    flag = true;
                    option = input.nextInt();
                    if (option < 1 || option > 6) {
                        throw new Exception("Opção inválida!");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, insira uma opção válida");
                    input.nextLine();
                    flag = false;
                }
            }
            input.nextLine();
            clear();

            switch (option) {
                case 1:
                    cashier.toSell(products, clients, employees);
                    break;
                case 2:
                    cashier.cancelSale(products);
                    break;
                case 3:
                    cashier.findSale();
                    break;
                case 4:
                    cashier.salesReport();
                    break;
                case 5:
                    isOpen = cashier.closeCashier();
                    break;
                case 6:
                    break;
            }
        } else {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Abrir caixa");
            System.out.println("\t[2] - Relatório de vendas");
            System.out.println("\t[3] - Voltar");

            int option = 0;
            boolean flag = false;

            while (!flag) {
                try {
                    option = 0;
                    flag = true;
                    option = input.nextInt();
                    if (option < 1 || option > 5) {
                        throw new Exception("Opção inválida!");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, insira uma opção válida");
                    input.nextLine();
                    flag = false;
                }
            }
            input.nextLine();
            clear();

            switch (option) {
                case 1:
                    isOpen = cashier.openCashier();
                    break;
                case 2:
                    cashier.salesReport();
                    break;
                case 3:
                    break;
            }
        }
        System.out.println("Pressione ENTER para prosseguir!");
        input.nextLine();
    }

    private void clientManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar cliente");
        System.out.println("\t[2] - Remover cliente");
        System.out.println("\t[3] - Visualizar clientes");
        System.out.println("\t[4] - Buscar cliente");
        System.out.println("\t[5] - Alterar cadastro de cliente");
        System.out.println("\t[6] - Voltar");

        int option = 0;
        boolean flag = false;

        while (!flag) {
            try {
                option = 0;
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 6) {
                    throw new Exception("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        clear();

        String cpf = null;
        Client client;

        switch (option) {
            case 1:
                client = clientManagement.addClient();
                clients.add(client);
                break;
            case 2:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do cliente que será removido: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }
                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    clients.remove(client);
                    System.out.println("Cliente removido!");
                }
                break;
            case 3:
                clientManagement.showAllClients(clients);
                break;
            case 4:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do cliente que será buscado: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }
                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    System.out.println(client);
                }
                break;
            case 5:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do cliente que terá o cadastro alterado: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }
                Client aux = clientManagement.findClient(cpf, clients);
                if (aux == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    client = clientManagement.changeClient(aux);
                    clients.remove(aux);
                    clients.add(client);
                }
                break;
            case 6:
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private void employeeManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar funcionário");
        System.out.println("\t[2] - Remover funcionário");
        System.out.println("\t[3] - Visualizar funcionários");
        System.out.println("\t[4] - Buscar funcionário");
        System.out.println("\t[5] - Alterar cadastro de funcionário");
        System.out.println("\t[6] - Voltar");

        int option = 0;
        boolean flag = false;

        while (!flag) {
            try {
                option = 0;
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 6) {
                    throw new Exception("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        clear();

        String cpf = null;
        Employee employee;

        switch (option) {
            case 1:
                employee = employeeManagement.addEmployee();
                employees.add(employee);
                break;
            case 2:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do funcionário que será removido: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }

                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    System.out.println("Funcionário removido!");
                    employees.remove(employee);
                }
                break;
            case 3:
                employeeManagement.showAllEmployees(employees);
                break;
            case 4:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do funcionário que será buscado: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }

                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    System.out.println(employee);
                }
                break;
            case 5:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("CPF do funcionário que terá o cadastro alterado: ");
                        cpf = input.nextLine();
                        if (!validateCpf(cpf) || cpf.length() != 11) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um CPF válido");
                        flag = false;
                    }
                }

                Employee aux = employeeManagement.findEmployee(cpf, employees);
                if (aux == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    employee = employeeManagement.changeEmployee(aux);
                    employees.remove(aux);
                    employees.add(employee);
                }
                break;

            case 6:
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private void stockManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar produto");
        System.out.println("\t[2] - Remover produto");
        System.out.println("\t[3] - Visualizar produtos");
        System.out.println("\t[4] - Buscar produto");
        System.out.println("\t[5] - Alterar produto");
        System.out.println("\t[6] - Voltar");

        int option = 0;
        boolean flag = false;

        while (!flag) {
            try {
                option = 0;
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 6) {
                    throw new Exception("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        clear();

        Product product = null;
        int code = 0;

        switch (option) {
            case 1:
                product = stock.addProduct();
                if (product != null) {
                    products.add(product);
                }
                break;
            case 2:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o código do produto: ");
                        code = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um código válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();
                product = stock.findProduct(code, products);
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    products.remove(product);
                    System.out.println("Produto removido!");
                }
                break;
            case 3:
                stock.showAllProducts(products);
                break;
            case 4:
                flag = false;
                while (!flag) {
                    try {
                        System.out.print("Insira o código do produto: ");
                        flag = true;
                        code = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um código válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();
                product = stock.findProduct(code, products);
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    System.out.println("\t" + product + "\n");
                }
                break;
            case 5:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o código do produto: ");
                        code = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um código válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();
                Product aux = stock.findProduct(code, products);
                if (aux == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    product = stock.changeProduct(aux);
                    products.remove(aux);
                    products.add(product);
                }
                break;
            case 6:
                break;
        }
        System.out.println("Pressione ENTER para prosseguir!");
        input.nextLine();
    }

    private boolean validateCpf(String cpf) {
        return cpf.matches("[0-9]*");
    }

    private void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

}
