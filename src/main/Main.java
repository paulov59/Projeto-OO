package main;

import products.*;
import people.*;

import java.util.*;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static boolean isOpen = false;
    public static CashierManagement cashier = new CashierManagement();
    public static ClientManagement client = new ClientManagement();
    public static EmployeeManagement employee = new EmployeeManagement();
    public static StockManagement stock = new StockManagement();


    public static void main(String[] args) {
        clear();
        System.out.println("Bem vindo ao Store Manager!");
        System.out.println("Pressione < CTRL + C > para sair ou selecione uma das opções no menu...");
        int option = menu();
        do {

            if (option > 5 || option < 1) {
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
                    cashier.toSell();
                    break;
                case 2:
                    cashier.cancelSale();
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
        System.out.println("Clientes");
    }

    private static void employeeManagement() {
        System.out.println("Funcionários");
    }

    private static void stockManagement() {
        System.out.println("Estoque");
    }

    public static void clear() {
        for (int i = 0; i < 150; i++) {
            System.out.println();
        }
    }

}
