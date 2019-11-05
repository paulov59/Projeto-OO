package products;

public class Merchandise implements Product {
    protected String name;
    protected String type;
    protected double price;
    protected double discount;
    protected double delivery;

    public Merchandise(String name, double price, double delivery) {
        this.name = name;
        this.price = price;
        this.delivery = delivery;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
        this.price = this.price * discount/100;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    @Override
    public void setNewPrice(double increase) {
        this.discount = 0;
        double current = this.price;
        this.price = current + (current * increase/100) + (delivery * 0.1);
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    public double getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return this.name + ": R$ " + this.price + " - Entrega: R$" + this.delivery;
    }

}
