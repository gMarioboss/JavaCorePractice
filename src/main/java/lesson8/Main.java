package lesson8;

public class Main {
    static int winStreak = 0;
    static Participants[] participants = {new Human("Человек"), new Cat("Кот"), new Robot("Робот")};
    static Barriers[] barriers = {new Treadmill(), new Wall(), new Wall(), new Treadmill(), new Wall()};

    public static void main(String[] args) throws InterruptedException {
        competition();
    }

    private static void competition() throws InterruptedException {
        for (Participants participant : participants) {

            winStreak = 0;

            for (Barriers barrier : barriers) {

                Thread.sleep(3000);

                if (barrier.overCome(participant)) {
                    winStreak++;
                    if (winStreak == barriers.length) {
                        System.out.printf("%s прошел все испытания!%n%n", participant.getName());
                    }
                    continue;
                }

                System.out.printf("%s выбывает из соревнования!%n%n", participant.getName());
                break;
            }
        }
    }
}
