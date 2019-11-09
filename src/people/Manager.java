package people;

public class Manager extends Employee {
    protected String username;
    protected String password;

    public Manager (String name, long cpf) {
        super(name, cpf);
    }

    public Manager() {

    }

    public void setUser(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
    }

    public String getUser() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
