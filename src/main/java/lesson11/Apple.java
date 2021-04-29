package lesson11;

public class Apple extends Fruit{
    protected double weight = 1.0;

    public double getWeight() {
        return weight;
    }

    @Override
    String getName() {
        return "Яблоки";
    }

}
