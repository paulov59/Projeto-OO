package main;

import people.Client;

import java.util.*;

public class ClientManagement {

    private Scanner input = new Scanner(System.in);

    public Client addClient() {
        System.out.print("Nome: ");
        String name = input.nextLine();

        System.out.print("CPF: ");
        long cpf = input.nextLong();
        Client client = new Client(name, cpf);

        System.out.println("Endereço: ");
        String address = input.nextLine();
        client.setAddress(address);

        return client;
    }

    public void showAllClients(ArrayList<Client> clients){
        if (clients.isEmpty()) {
            System.out.println("Não há funcionários cadastrados");
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
        System.out.println("Selecione:");
        System.out.println("\t[1] - Modificar nome");
        System.out.println("\t[2] - Modificar endereço");
        System.out.println("\t[3] - Voltar");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.println("Novo nome: ");
                String name = input.nextLine();
                client.setName(name);
                break;
            case 2:
                System.out.println("Novo endereço: ");
                String address = input.nextLine();
                client.setAddress(address);
                break;
            default:
                break;
        }
        return client;
    }
}
