package lesson6;

public class Main {
    static Cat cat1 = new Cat("Барс");
    static Cat cat2 = new Cat("Беляш");

    static Dog dog1 = new Dog("Шарик");
    static Dog dog2 = new Dog("Бонич");

    public static void main(String[] args) {
        catCompetition();
        dogCompetition();
    }

    private static void catCompetition() {
        cat1.printInfo();
        cat1.run(280);
        cat1.jump(1.5);
        cat1.swim(10);

        cat2.printInfo();
        cat2.run(120);
        cat2.jump(3);
        cat2.swim(10);
    }

    private static void dogCompetition() {
        dog1.printInfo();
        dog1.run(750);
        dog1.jump(0.7);
        dog1.swim(5);

        dog2.printInfo();
        dog2.run(550);
        dog2.jump(1.7);
        dog2.swim(16);
    }
}
