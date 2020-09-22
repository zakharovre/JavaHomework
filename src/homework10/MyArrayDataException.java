package homework10;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int a, int b) {
        super("Данные в ячейке arr[" + a + "][" + b + "] не привести к типу int");
    }
}
