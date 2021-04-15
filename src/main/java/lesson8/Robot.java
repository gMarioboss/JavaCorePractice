package lesson8;

public class Robot implements Participants {
    int runDistance = (int) (280 + Math.random() * 301);
    double jumpHeight =  (double) Math.round((0.6 + Math.random() * 1) * 10) / 10;
    String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        return runDistance >= distance;
    }

    @Override
    public boolean jump(double height) {
        return jumpHeight >= height;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public String getName() {
        return name;
    }
}
