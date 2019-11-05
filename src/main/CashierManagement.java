package main;

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

    public void toSell() {
        System.out.println("Realizar venda");
    }

    public void cancelSale() {
        System.out.println("Cancelar venda");
    }

    public void findSale() {
        System.out.println("Buscar venda");
    }

    public void salesReport() {
        for (Sale sale:sales) {
            System.out.println(sale);
        }
    }

}
