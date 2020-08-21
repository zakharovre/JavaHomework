package homework2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] m = new int[8];
        for(int i=0; i< m.length; i++)
            m[i]=i*3;
        System.out.println(Arrays.toString(m));
    }
}

