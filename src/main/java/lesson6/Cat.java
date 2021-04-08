package lesson6;

public class Cat extends Animal {
    protected int catRunDistance = 100 + (int)(Math.random() * 201);
    protected int catJumpHeight = 1 + (int)(Math.random() * 3);

    public Cat(String name) {
        super(name);
    }

    @Override
    void run(int distance) {
        if (catRunDistance >= distance) {
            System.out.println("Котик " + name + " справился с забегом!");
        } else {
            System.out.println("Котик " + name + ",к сожалению, не справился с забегом!");
        }
    }

    @Override
    void jump(double height) {
        if (catJumpHeight >= height) {
            System.out.println("Котик " + name + " перепрыгнул через препятствие!");
        } else {
            System.out.println("Котик " + name + ",к сожалению, не смог перепрыгнуть через препятствие");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println("Котик " + name + " даже не полез в воду, ибо не умеет плавать!");
    }

    @Override
    public String toString() {
        return "\nКот " + name
                + " бегает на дистанцию " + catRunDistance
                + ", прыгает на " + catJumpHeight
                + " метра вверх" +
                " и плавать не умеет!";
    }
}
