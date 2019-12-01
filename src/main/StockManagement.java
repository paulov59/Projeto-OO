package main;

import products.*;
import java.util.*;

public class StockManagement {

    Scanner input = new Scanner(System.in);

    public Product addProduct() {
        int option = 0;
        boolean flag;

        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar mercadoria");
        System.out.println("\t[2] - Adicionar serviço");
        System.out.println("\t[3] - Voltar");

        flag = false;
        while (!flag) {
            try {
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    throw new Exception("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println("Por favor, selecione uma opção válida");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();
        Product product = null;

        int code = 0, amount = 0;
        double price = 0, delivery = 0;
        String name;

        switch (option) {
            case 1:
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
                System.out.print("Insira o nome do produto: ");
                name = input.nextLine();

                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o preço do produto: R$ ");
                        price = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um valor válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o frete do produto: R$ ");
                        delivery = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um valor válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira a quantidade da mercadoria: ");
                        amount = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira uma quantidade válida");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                product = new Merchandise(code, name, price, delivery, amount);
                System.out.println("Produto adicionado");
                break;

            case 2:
                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o código do serviço: ");
                        code = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um código válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                System.out.print("Insira o nome do serviço: ");
                name = input.nextLine();

                flag = false;
                while (!flag) {
                    try {
                        flag = true;
                        System.out.print("Insira o preço do serviço: R$ ");
                        price = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Por favor, insira um valor válido");
                        input.nextLine();
                        flag = false;
                    }
                }
                input.nextLine();

                product = new Service(code, name, price);
                System.out.println("Produto adicionado.");
                break;

            case 3:
                break;
        }

        return product;
    }

    public void showAllProducts(ArrayList<Product> products){
        if (products.isEmpty()) {
            System.out.println("Não há produtos cadastrados!");
        } else{
            for (Product product: products) {
                System.out.println("\t" + product + "\n");
            }
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
        int option;
        boolean flag;
        System.out.println("\t" + product + "\n");

        if (product instanceof Merchandise) {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Modificar nome");
            System.out.println("\t[2] - Modificar preço");
            System.out.println("\t[3] - Modificar frete");
            System.out.println("\t[4] - Modificar quantidade de mercadoria");
            System.out.println("\t[5] - Voltar");

            option = 0;
            flag = false;
            while (!flag) {
                try {
                    flag = true;
                    option = input.nextInt();
                    if (option < 1 || option > 5) {
                        throw new Exception("Opção inválida");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, selecione uma opção válida");
                    input.nextLine();
                    flag = false;
                }
            }
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Insira o novo nome do produto: ");
                    String name = input.nextLine();
                    product.setName(name);
                    break;

                case 2:
                    double price = 0;
                    flag = false;
                    while (!flag) {
                        try {
                            flag = true;
                            System.out.print("Insira o preço do produto: R$ ");
                            price = input.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Por favor, insira um valor válido");
                            input.nextLine();
                            flag = false;
                        }
                    }
                    input.nextLine();
                    product.setPrice(price);
                    break;

                case 3:
                    double delivery = 0;
                    flag = false;
                    while (!flag) {
                        try {
                            flag = true;
                            System.out.print("Insira o frete do produto: R$ ");
                            delivery = input.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Por favor, insira um valor válido");
                            input.nextLine();
                            flag = false;
                        }
                    }
                    input.nextLine();
                    ((Merchandise) product).setDelivery(delivery);
                    break;

                case 4:
                    int amount = 0;
                    flag = false;
                    while (!flag) {
                        try {
                            flag = true;
                            System.out.print("Insira a quantidade de mercadorias: ");
                            amount = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Por favor, insira um valor válido");
                            input.nextLine();
                            flag = false;
                        }
                    }
                    input.nextLine();
                    ((Merchandise) product).setAmount(amount);
                    break;
            }

        } else {
            System.out.println("Selecione:");
            System.out.println("\t[1] - Modificar nome");
            System.out.println("\t[2] - Modificar preço");
            System.out.println("\t[3] - Voltar");

            option = 0;
            flag = false;
            while (!flag) {
                try {
                    flag = true;
                    option = input.nextInt();
                    if (option < 1 || option > 5) {
                        throw new Exception("Opção inválida");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, selecione uma opção válida");
                    input.nextLine();
                    flag = false;
                }
            }
            input.nextLine();

            switch (option){
                case 1:
                    System.out.print("Insira o novo nome do produto: ");
                    String name = input.nextLine();
                    product.setName(name);
                    break;

                case 2:
                    double price = 0;
                    flag = false;
                    while (!flag) {
                        try {
                            flag = true;
                            System.out.print("Insira o preço do produto: R$ ");
                            price = input.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Por favor, insira um valor válido");
                            input.nextLine();
                            flag = false;
                        }
                    }
                    input.nextLine();
                    product.setPrice(price);
                    break;
            }
        }
        return product;
    }

}
