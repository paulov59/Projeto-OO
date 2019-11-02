package products;

public interface Product {
    void setName(String name);
    void setPrice(double price);
    void setDiscount(double percent);
    void setNewPrice(double increase);
    String getName();
    double getPrice();
    double getDiscount();

}
