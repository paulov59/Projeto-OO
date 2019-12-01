package people;

public class People {
    protected String name;
    protected String cpf;

    public People (String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public People () {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

}
