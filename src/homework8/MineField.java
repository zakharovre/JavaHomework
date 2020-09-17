package homework8;


public class MineField {

    public static int[][] getArr() {

        int[][] field = new int[12][12];
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 10) + 1;
            int y = (int) (Math.random() * 10) + 1;
            if (field[x][y] == 0)
                field[x][y] = 9;
            else
                i--;
        }

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                int count = 0;
                if (field[i][j] == 0) {
                    for (int ni = i - 1; ni <= i + 1; ni++) {
                        for (int nj = j - 1; nj <= j + 1; nj++) {
                            if (field[ni][nj] == 9)
                                count++;
                        }
                    }
                    field[i][j] = count;
                }
            }
        }
        int[][] gField = new int[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(field[i + 1], 1, gField[i], 0, 10);
        }
        return gField;
    }
}

