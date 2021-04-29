package lesson11;

public class Orange extends Fruit{
    protected double weight = 1.5;

    public double getWeight() {
        return weight;
    }

    @Override
    String getName() {
        return "Апельсины";
    }

}
