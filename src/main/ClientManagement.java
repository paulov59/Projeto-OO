package main;

import people.Client;

import java.util.*;

public class ClientManagement {

    private Scanner input = new Scanner(System.in);

    public boolean validateCpf(String cpf) {
        return cpf.matches("[0-9]*");
    }

    public Client addClient() {
        System.out.print("Nome: ");
        String name = input.nextLine();

        String cpf = null;
        boolean flag = false;

        while (!flag) {
            try {
                flag = true;
                System.out.print("CPF: ");
                cpf = input.nextLine();
                if (!validateCpf(cpf) || cpf.length() != 11) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira um CPF válido");
                flag = false;
            }
        }

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

    public Client findClient(String cpf, ArrayList<Client> clients) {
        if (!clients.isEmpty()) {
            for (Client client: clients) {
                if (client.getCpf().equals(cpf)) {
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
