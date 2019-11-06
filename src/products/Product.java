package products;

public interface Product {
    void setCode(int code);
    void setName(String name);
    void setPrice(double price);
    void setDiscount(double percent);
    void setNewPrice(double increase);
    int getCode();
    String getName();
    double getPrice();
    double getDiscount();

}
