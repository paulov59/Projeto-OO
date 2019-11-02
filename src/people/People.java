package people;

public abstract class People {
    protected String name;
    protected int cpf;

    public People (String name, int cpf) {
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

    public int getCpf() {
        return cpf;
    }

}
