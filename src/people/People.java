package people;

public class People {
    protected String name;
    protected long cpf;

    public People (String name, long cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public People () {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public long getCpf() {
        return cpf;
    }

}
