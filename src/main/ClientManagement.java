package main;

import people.Client;

import java.util.*;

public class ClientManagement {

    private Scanner input = new Scanner(System.in);

    public Client addClient() {
        System.out.print("Nome: ");
        String name = input.nextLine();

        long cpf = 0;
        boolean flag = false;

        while (!flag) {
            try {
                flag = true;
                System.out.print("CPF: ");
                cpf = input.nextLong();
            } catch (Exception e) {
                System.out.println("Por favor, insira um CPF válido");
                input.nextLine();
                flag = false;
            }
        }
        input.nextLine();

        Client client = new Client(name, cpf);

        System.out.print("Endereço: ");
        String address = input.nextLine();
        client.setAddress(address);

        return client;
    }

    public void showAllClients(ArrayList<Client> clients){
        if (clients.isEmpty()) {
            System.out.println("Não há clientes cadastrados");
        } else {
            for (Client client:clients) {
                System.out.println(client);
            }
        }
    }

    public Client findClient(long cpf, ArrayList<Client> clients) {
        if (!clients.isEmpty()) {
            for (Client client: clients) {
                if (client.getCpf() == cpf) {
                    return client;
                }
            }
        }
        return null;
    }

    public Client changeClient (Client client) {
        System.out.println(client);
        System.out.println("Selecione:");
        System.out.println("\t[1] - Modificar nome");
        System.out.println("\t[2] - Modificar endereço");
        System.out.println("\t[3] - Voltar");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.print("Novo nome: ");
                String name = input.nextLine();
                client.setName(name);
                break;
            case 2:
                System.out.print("Novo endereço: ");
                String address = input.nextLine();
                client.setAddress(address);
                break;
            default:
                break;
        }
        return client;
    }
}
