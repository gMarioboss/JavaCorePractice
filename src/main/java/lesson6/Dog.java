package lesson6;

public class Dog extends Animal{
    protected int dogRunDistance = 400 + (int)(Math.random() * 201);
    protected double dogJumpHeight = (double)Math.round((0.5 + Math.random() * 2) * 10) / 10;
    protected int dogSwimDistance = 5 + (int)(Math.random() * 11);

    public Dog(String name) {
        super(name);
    }

    @Override
    void run(int distance) {
        if (dogRunDistance >= distance) {
            System.out.println("Собака " + this.name + " справилась с забегом!");
        } else {
            System.out.println("Собака " + this.name + ",к сожалению, не справилась с забегом!");
        }
    }

    @Override
    void jump(double height) {
        if (dogJumpHeight >= height) {
            System.out.println("Собака " + name + " перепрыгнула через препятствие!");
        } else {
            System.out.println("Собака " + name + ",к сожалению, не смогла перепрыгнуть через препятствие");
        }
    }

    @Override
    void swim(int distance) {
        if (dogSwimDistance >= distance) {
            System.out.println("Собака " + name + " переплыла дистанцию!");
        } else {
            System.out.println("Собака " + name + ",к сожалению, не смогла переплыть дистанцию и спасатели вытащили её из воды!");
        }
    }

    @Override
    public String toString() {
        return "\nСобака " + name
                + " бегает на дистанцию " + dogRunDistance
                + ", прыгает на " + dogJumpHeight
                + " метра вверх" +
                " и плавает на дистанцию " + dogSwimDistance
                + " метров";
    }


}
