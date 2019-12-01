package people;

public class Client extends People {
    protected int sales;
    protected String address;

    public Client(String name, String cpf) {
        super(name, cpf);
        this.sales = 0;
    }

    public void setSales() {
        this.sales++;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void removeSale(){
        this.sales--;
    }

    public int getSales() {
        return sales;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n\tCPF: %s\n\tEndereço: %s\n\tCompras realizadas: %d\n",
                this.name, this.cpf, this.address, this.sales);
    }
}
