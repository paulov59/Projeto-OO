package people;

public abstract class People {
    protected String name;
    protected String cpf;
    protected int age;

    public People (String name, String cpf, int age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public People () {

    }
}
