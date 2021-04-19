package lesson9;


public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"2", "2", "2", "2", "2"},
                {"2", "2", "2", "2", "2"},
                {"2", "2", "2", "2", "2"},
                {"2", "2", "2", "2", "2"},
                {"2", "2", "2", "2", "2"}
        };
        try {
            checkSize(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
         try {
             System.out.println("Сумма чисел массива = " + convertArray(array));
         }
        catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int convertArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(isConvertible(array[i][j])) {
                    throw new MyArrayDataException(i,j);
                }
                sum += Integer.parseInt(String.valueOf(array[i][j]));
            }
        }
        return sum;
    }

    private static void checkSize(String[][] array) throws MyArraySizeException {
            if (array.length != 4 && array[0].length != 4) {
                throw new MyArraySizeException();
            }
        }

    private static boolean isConvertible(String cell) {
        try {
           Integer.parseInt(cell);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
