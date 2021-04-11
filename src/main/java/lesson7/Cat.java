package lesson7;

public class Cat {
    protected String name;
    protected int maxSatiety = (int) (70 + Math.random() * 51);
    protected int currentSatiety = 0;

    public Cat(String name) {
        this.name = name;
    }

    void eat(Plate plateNumber, int foodValue) {
        currentSatiety += Math.min(maxCurrent(), foodValue);
    }

    boolean isCatFed() {
        return currentSatiety != maxSatiety;
    }

    int maxCurrent () {
        return maxSatiety - currentSatiety;
    }

    void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
            return "Котик " + name +
                    "".concat(currentSatiety == maxSatiety ? " сыт и доволен!" : " голоден и просит есть!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSatiety() {
        return maxSatiety;
    }

    public void setMaxSatiety(int maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public int getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(int currentSatiety) {
        this.currentSatiety = currentSatiety;
    }
}
