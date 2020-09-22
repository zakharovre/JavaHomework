package homework10;

public class Task {
    public static void main(String[] args) {
        String[][] someArr = {{"1", "2", "3", "1"}, {"4", "2", "4", "2"}, {"3", "2", "2", "1"}, {"4", "4", "2", "5"}};
        try {
            System.out.println(getSumFromArray(someArr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSumFromArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        if (arr.length != 4 || arr[0].length != 4)
            throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

