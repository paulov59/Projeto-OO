package main;

import people.Client;
import people.Employee;
import products.*;

import javax.swing.*;
import java.util.*;

public class Sale {
    protected int sale;
    protected Client client;
    protected Employee employee;
    protected float totalPrice;
    protected ArrayList<Product> products = new ArrayList<Product>();

    public Sale(int sale, Client client, Employee employee) {
        this.sale = sale;
        this.client = client;
        this.employee = employee;
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
            return String.format("\tNota fiscal: %d\n\t   Vendedor: %s\n\t   Cliente: não identificado\n\t   Total: R$ %.2f",
                    this.sale, this.employee.getName(), this.totalPrice);
        } else {
            return String.format("\tNota fiscal: %d\n\t   Vendedor: %s\n\t   Cliente: %s\n\t   Total: R$ %.2f",
                    this.sale, this.employee.getName(), this.client.getName(), this.totalPrice);
        }
    }
}
