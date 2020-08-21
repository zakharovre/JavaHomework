package homework2;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] m = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(m));
        for(int i=0; i< m.length; i++) {
            if(m[i]<6)
                m[i]*=2;
        }
        System.out.println(Arrays.toString(m));
    }
}
