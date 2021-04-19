package lesson9;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException() {
        super("Передаваемый массив не соответcтвует размеру 4х4");
    }
}
