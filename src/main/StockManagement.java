package main;

import products.*;
import java.util.*;

public class StockManagement {

    Scanner input = new Scanner(System.in);

    public Product addProduct() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar mercadoria");
        System.out.println("\t[2] - Adicionar serviço");

        int option = input.nextInt();
        input.nextLine();
        Product product = null;

        int code, amount;
        double price, delivery;
        String name;

        switch (option) {
            case 1:
                System.out.print("Insira o código do produto: ");
                code = input.nextInt();
                input.nextLine();

                System.out.print("Insira o nome do produto: ");
                name = input.nextLine();

                System.out.print("Insira o preço do produto: R$ ");
                price = input.nextDouble();

                System.out.print("Insira o frete do produto: R$ ");
                delivery = input.nextDouble();

                System.out.print("Insira a quantidade da mercadoria: ");
                amount = input.nextInt();

                product = new Merchandise(code,name, price, delivery, amount);
                break;

            case 2:
                System.out.print("Insira o código do serviço: ");
                code = input.nextInt();
                input.nextLine();

                System.out.print("Insira o nome do serviço: ");
                name = input.nextLine();

                System.out.print("Insira o preço do serviço: R$ ");
                price = input.nextDouble();

                product = new Service(code,name, price);
                break;
        }

        return product;
    }

    public void showAllProducts(ArrayList<Product> products){
        if (products.isEmpty()) {
            System.out.println("Não há produtos cadastrados!");
        }
        for (Product product: products) {
            System.out.println("\t" + product + "\n");
        }
    }

    public Product findProduct(int code, ArrayList<Product> products) {
        for (Product product: products) {
            if (product.getCode() == code) {
                return product;
            }

        }
        return null;
    }

    public Product changeProduct (Product product) {
        return product;
    }

}
