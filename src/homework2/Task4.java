package homework2;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[][] m = new int[10][10];
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                m[i][j] = 0;
            }
        }
        for(int i = 0; i< m.length; i++){
            for(int j=0; j<m[i].length; j++){
                if(i==j || i==(9-j)){
                    m[i][j] = 1;
                }
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
