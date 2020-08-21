package homework2;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] m = new int[15];
        for(int i = 0; i<m.length; i++){
            m[i] = (int)(Math.random()*2);
        }
        System.out.println(Arrays.toString(m));
        for(int i = 0; i< m.length; i++){
            if(m[i]==0)
                m[i]=1;
            else
                m[i]=0;
        }
        System.out.println(Arrays.toString(m));
    }
}
