package people;

public class Manager extends Employee {
    protected String username;
    protected String password;

    public Manager (String name, int cpf) {
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

    public String getUser() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
