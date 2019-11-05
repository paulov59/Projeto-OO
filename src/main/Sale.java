package main;

import products.*;
import java.util.*;

public class Sale {
    protected int sale;
    protected int client;
    protected static float totalPrice;
    protected static ArrayList<Merchandise> merchandises = new ArrayList<Merchandise>();
    protected static ArrayList<Service> services = new ArrayList<Service>();

    public Sale(int sale, int client) {
        this.sale = sale;
        this.client = client;
        this.totalPrice = 0;
    }

    public int getSale() {
        return sale;
    }

    public int getClient() {
        return client;
    }

    public float getPrice() {
        return totalPrice;
    }

    public static void setMerchandises(Merchandise merchandise) {
        totalPrice += merchandise.getPrice() + merchandise.getDelivery();
        merchandises.add(merchandise);
    }

    public static void setServices(Service service) {
        totalPrice += service.getPrice();
        services.add(service);
    }

    @Override
    public String toString() {
        return "\tNota fiscal: " + this.sale
                + "\n\tCliente: " + this.client
                + "Total: R$ " + this.totalPrice;
    }
}
