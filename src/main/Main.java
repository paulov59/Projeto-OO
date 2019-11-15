package main;

import products.*;
import people.*;

import java.util.*;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static boolean isOpen = false;
    public static CashierManagement cashier = new CashierManagement();
    public static ClientManagement clientManagement = new ClientManagement();
    public static EmployeeManagement employeeManagement = new EmployeeManagement();
    public static StockManagement stock = new StockManagement();

    public static ArrayList<Product> products = new ArrayList<Product>();
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();


    public static void main(String[] args) {
        clear();
        System.out.println("Bem vindo ao Store Manager!");
        System.out.println("Selecione uma das opções no menu...");
        int option = menu();
        do {
            if (option == 5) {
                break;
            }else if (option > 5 || option < 1) {
                System.out.println("Opção inválida!");
            }
            clear();
            option = menu();
        } while (option != 5);

        System.out.println("\nObrigado por usar o Store Manager!\n");

    }

    public static int menu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Gerenciar caixa");
        System.out.println("\t[2] - Gerenciar clientes");
        System.out.println("\t[3] - Gerenciar funcionários");
        System.out.println("\t[4] - Gerenciar estoque");
        System.out.println("\t[5] - Sair");

        int option = input.nextInt();

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

    private static void cashierManagement() {
        clear();
        if (isOpen) {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Realizar venda");
            System.out.println("\t[2] - Cancelar venda");
            System.out.println("\t[3] - Buscar venda");
            System.out.println("\t[4] - Relatório de vendas");
            System.out.println("\t[5] - Fechar caixa");
            System.out.println("\t[6] - Voltar");

            int option = input.nextInt();
            input.nextLine();
            clear();

            switch (option) {
                case 1:
                    cashier.toSell(products, clients);
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
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Pressioner ENTER para prosseguir.");
            input.nextLine();
        } else {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Abrir caixa");
            System.out.println("\t[2] - Relatório de vendas");
            System.out.println("\t[3] - Voltar");

            int option = input.nextInt();
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
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Pressioner ENTER para prosseguir.");
            input.nextLine();
        }
    }

    private static void clientManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar cliente");
        System.out.println("\t[2] - Remover cliente");
        System.out.println("\t[3] - Visualizar clientes");
        System.out.println("\t[4] - Buscar cliente");
        System.out.println("\t[5] - Alterar cadastro de cliente");
        System.out.println("\t[6] - Voltar");

        int option = input.nextInt();
        input.nextLine();
        clear();

        long cpf;
        Client client;

        switch (option) {
            case 1:
                client = clientManagement.addClient();
                clients.add(client);
                break;
            case 2:
                System.out.println("CPF do cliente que será removido: ");
                cpf = input.nextLong();
                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    clients.remove(client);
                }
                break;
            case 3:
                clientManagement.showAllClients(clients);
                break;
            case 4:
                System.out.println("CPF do cliente que será buscado: ");
                cpf = input.nextLong();
                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    System.out.println(client);
                }
                break;
            case 5:
                System.out.println("CPF do cliente que terá o cadastro alterado: ");
                cpf = input.nextLong();
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
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private static void employeeManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar funcionário");
        System.out.println("\t[2] - Demitir funcionário");
        System.out.println("\t[3] - Visualizar funcionários");
        System.out.println("\t[4] - Buscar funcionário");
        System.out.println("\t[5] - Alterar cadastro de funcionário");
        System.out.println("\t[6] - Voltar");

        int option = input.nextInt();
        input.nextLine();
        clear();

        long cpf;
        Employee employee;

        switch (option) {
            case 1:
                employee = employeeManagement.addEmployee();
                employees.add(employee);
                break;
            case 2:
                System.out.println("CPF do funcionário que será removido: ");
                cpf = input.nextLong();
                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    employees.remove(employee);
                }
                break;
            case 3:
                employeeManagement.showAllEmployees(employees);
                break;
            case 4:
                System.out.println("CPF do funcionário que será buscado: ");
                cpf = input.nextLong();
                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    System.out.println(employee);
                }
                break;
            case 5:
                System.out.println("CPF do funcionário que terá o cadastro alterado: ");
                cpf = input.nextLong();
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
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private static void stockManagement() {
        clear();
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar produto");
        System.out.println("\t[2] - Remover produto");
        System.out.println("\t[3] - Visualizar produtos");
        System.out.println("\t[4] - Buscar produto");
        System.out.println("\t[5] - Alterar produto");
        System.out.println("\t[6] - Voltar");

        int option = input.nextInt();
        input.nextLine();
        clear();

        Product product;
        int code;

        switch (option) {
            case 1:
                product = stock.addProduct();
                products.add(product);
                break;
            case 2:
                System.out.print("Insira o código do produto: ");
                code = input.nextInt();
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
                System.out.print("Insira o código do produto: ");
                code = input.nextInt();
                product = stock.findProduct(code, products);
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    System.out.println("\t" + product + "\n");
                }
                break;
            case 5:
                System.out.print("Insira o código do produto: ");
                code = input.nextInt();
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
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    public static void clear() {
        for (int i = 0; i < 150; i++) {
            System.out.println();
        }
    }

}
