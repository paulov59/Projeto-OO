package people;

public class Employee extends People {
    protected int employeeId;
    protected double salary;

    public Employee (String name, long cpf) {
        super(name, cpf);
    }

    public Employee() {

    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n\tCPF: %d\n\tIdentidade profissional: %d\n\tSalário: R$ %.2f\n",
                this.name, this, cpf, this.employeeId, this.salary);
    }
}
