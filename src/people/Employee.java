package people;

public class Employee extends People {
    protected int employeeId;
    protected int workHours;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public int getWorkHours() {
        return workHours;
    }

}
