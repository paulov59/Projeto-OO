package products;

public class Service implements Product {
    protected int code;
    protected String name;
    protected double price;
    protected double discount;

    public Service(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
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

    @Override
    public void setNewPrice(double increase) {
        this.discount = 0;
        double current = this.price;
        this.price = current + (current * increase/100);
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
        return price;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Código: " + this.code + " - " + this.name + ": R$ " + this.price;
    }

}
