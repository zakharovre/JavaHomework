package homework2;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] m = new int[15];
        for(int i=0; i<m.length; i++)
            m[i] = (int)(Math.random()*200 - 100);
        System.out.println(Arrays.toString(m));
        Arrays.sort(m);
        System.out.println("max = " + m[m.length-1]);
        System.out.println("min = " + m[0]);
    }
}
