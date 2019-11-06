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
            int cpf = input.nextInt();
            ClientManagement clientManage = null;
            client = clientManage.findClient(cpf, clients);
        }else {
            client = null;
        }

        int size = 1 + sales.size();
        Sale sale = new Sale(size, client);

        System.out.print("Digite o código do produto: ");
        int code = input.nextInt();
        Product product = null;
        for (Product aux: products) {
            if (aux.getCode() == code) {
                product = aux;
                break;
            }
        }
        if (!product.equals(null)) {
            sale.setProduct(product);
        } else {
            System.out.println("Produto não encontrado!");
        }
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
            }else {
                break;
            }
        }

        double finalPrice = sale.getPrice();
        sales.add(sale);

        System.out.println("Total: R$" + finalPrice);

        currentMoney += finalPrice;

    }

    public void cancelSale() {
        System.out.println("Cancelar venda");
    }

    public void findSale() {
        System.out.println("Buscar venda");
    }

    public void merchandiseExchange() {
        System.out.println("Troca de mercadoria");
    }

    public void salesReport() {
        for (Sale sale:sales) {
            System.out.println(sale);
        }
    }

}
