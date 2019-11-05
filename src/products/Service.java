package products;

public class Service implements Product {
    protected String name;
    protected double price;
    protected double discount;

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

    @Override
    public void setNewPrice(double increase) {
        this.discount = 0;
        double current = this.price;
        this.price = current + (current * increase/100);
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

    @Override
    public String toString() {
        return this.name + ": R$ " + this.price;
    }

}
