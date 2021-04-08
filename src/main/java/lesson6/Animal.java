package lesson6;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    void printInfo () {
        System.out.println(this);
    }

    abstract void run (int distance);
    abstract void jump (double height);
    abstract void swim (int distance);

}
