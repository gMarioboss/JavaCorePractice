package lesson9;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int row, int column) {
        super(String.format("Не удалось преобразовать в integer ячейку на позиции [%d],[%d]", row, column));
    }
}
