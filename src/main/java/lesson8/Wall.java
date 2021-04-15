package lesson8;

public class Wall implements Barriers {
    double height = (double) Math.round((0.5 + Math.random() * 1) * 10) / 10;

    @Override
    public boolean overCome(Participants participant) {
        if (participant.jump(height)) {
            System.out.printf("%s (%s) перепрыгнул препятствие в %s метров!%n", participant.getName(),
                    participant.getJumpHeight(), height);
            return true;
        }
        System.out.printf("%s (%s) не перепрыгнул препятствие в %s метров!%n", participant.getName(),
                participant.getJumpHeight(), height);
        return false;
    }

    public double getHeight() {
        return height;
    }

}
