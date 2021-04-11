package lesson7;

public class Plate {
    protected int food;
    protected int number;

    public Plate(int food) {
        this.food = food;
    }

    void addFood(int foodAmount) {
        food += foodAmount;
    }

    void removeEatenFood(Cat catNumber, int foodValue, int number) {
        food -= Math.min(catNumber.maxCurrent(), foodValue);
        this.number = number;
    }

    boolean isPlateEmpty() {
        return food != 0;
    }

    void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Количество еды в " + (number + 1) + " миске: " + food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }
}
