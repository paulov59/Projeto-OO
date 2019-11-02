package people;

public class Client extends People {
    protected int sales;
    protected String address;

    public Client(String name, int cpf) {
        super(name, cpf);
    }

    public Client() {

    }

    public void setSales() {
        this.sales++;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSales() {
        return sales;
    }

    public String getAddress() {
        return address;
    }

}
