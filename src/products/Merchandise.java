package products;

public class Merchandise implements Product {
    protected int code;
    protected String name;
    protected double price;
    protected double discount;
    protected double delivery;
    protected int amount;

    public Merchandise(int code, String name, double price, double delivery, int amount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.delivery = delivery;
        this.amount = amount;
        this.discount = 0;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void setNewPrice(double increase) {
        this.discount = 0;
        double current = this.price;
        this.price = current + (current * increase/100) + (delivery * 0.1);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price + delivery;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    public double getDelivery() {
        return delivery;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Código: " + this.code + " - " + this.name + ": R$ " + this.price + " - Entrega: R$ " + this.delivery + " - Quantidade: " + this.amount;
    }

}
