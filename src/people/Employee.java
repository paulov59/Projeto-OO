package people;

public class Employee extends People {
    protected int employeeId;
    protected int workHours;
    protected double salary;

    public Employee (String name, int cpf) {
        super(name, cpf);
    }

    public Employee() {

    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getWorkHours() {
        return workHours;
    }

    public double getSalary() {
        return salary;
    }
}
