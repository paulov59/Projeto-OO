package main;

import people.Client;
import products.*;

import javax.swing.*;
import java.util.*;

public class Sale {
    protected int sale;
    protected Client client;
    protected static float totalPrice;
    protected ArrayList<Product> products = new ArrayList<Product>();

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

    public void setProduct(Product product) {
        totalPrice += product.getPrice();
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        if (this.client == null) {
            return String.format("\tNota fiscal: %d\n\t   Cliente: não identificado\n\t   Total: R$ %.2f", this.sale, this.totalPrice);
        } else {
            return String.format("\tNota fiscal: %d\n\t   Cliente: %d\n\t   Total: R$ %.2f", this.sale, this.client.getCpf(), this.totalPrice);
        }
    }
}
