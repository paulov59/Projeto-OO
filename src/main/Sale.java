package main;

import people.Client;
import products.*;
import java.util.*;

public class Sale {
    protected int sale;
    protected Client client;
    protected static float totalPrice;
    protected static ArrayList<Product> products = new ArrayList<Product>();

    public Sale(int sale, Client client) {
        this.sale = sale;
        this.client = client;
        this.totalPrice = 0;
    }

    public int getSale() {
        return sale;
    }

    public Client getClient() {
        return client;
    }

    public float getPrice() {
        return totalPrice;
    }

    public static void setProduct(Product product) {
        totalPrice += product.getPrice();
        products.add(product);
    }

    @Override
    public String toString() {
        return "\tNota fiscal: " + this.sale
                + "\n\tCliente: " + this.client
                + "Total: R$ " + this.totalPrice;
    }
}
