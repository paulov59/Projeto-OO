package main;

import java.util.*;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        clear();
        System.out.println("Bem vindo ao Store Manager!\n");
        System.out.println("Pressione < CTRL + C > para sair ou selecione uma das opções no menu...");

        int op = 1;
        do {
            clear();
            if (op > 5 || op < 1) {
                System.out.println("Opção inválida!");
            }
            op = menu();
        } while (op != 5);

        System.out.println("\nObrigado por usar o Store Manager!\n");

    }

    public static int menu() {
        System.out.println("Selecione:");
        System.out.println("\t1 - Gerenciar caixa");
        System.out.println("\t2 - Gerenciar clientes");
        System.out.println("\t3 - Gerenciar funcionários");
        System.out.println("\t4 - Gerenciar estoque");
        System.out.println("\t5 - Sair");

        int op = input.nextInt();

        switch (op) {
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
        return op;
    }

    private static void cashierManagement() {
        System.out.println("Caixa");
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
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
