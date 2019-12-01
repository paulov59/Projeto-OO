package people;

public class Employee extends People {
    protected int employeeId;
    protected double salary;
    protected int sales;

    public Employee (String name, String cpf) {
        super(name, cpf);
        sales = 0;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSales() {
        this.sales++;
    }

    public void removeSale(){
        this.sales--;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n\tCPF: %s\n\tIdentidade profissional: %d\n\tSalário: R$ %.2f\n\tVendas: %d\n",
                this.name, this.cpf, this.employeeId, this.salary, this.sales);
    }

}
