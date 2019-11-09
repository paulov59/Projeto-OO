package main;

import people.Client;
import java.util.ArrayList;

public class ClientManagement {
    public Client addClient() {
        Client client = new Client("nome", 10);
        return client;
    }

    public Client removeClient() {
        Client client = new Client("nome", 10);
        return client;
    }

    public void showAllClients(ArrayList<Client> clients){
        System.out.println(clients);
    }

    public Client findClient(long cpf, ArrayList<Client> clients) {
        for (Client client: clients) {
            if (client.getCpf() == cpf) {
                return client;
            }
        }
        return null;
    }

    public Client changeClient (Client client) {
        return client;
    }
}
