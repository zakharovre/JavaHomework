package homework2;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int[] m = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(m));
        int[] n = shift(m,-17);
        System.out.println(Arrays.toString(n));
    }

    public static int[] shift(int[] m, int a) {
        int var2;
        for(int j=0;j<Math.abs(a);j++) {
            if (a < 0) {
                int var1 = m[m.length - 1];
                for (int i = m.length; i > 0; i--) {
                    var2 = m[i - 1];
                    m[i - 1] = var1;
                    var1 = var2;
                }
                m[m.length - 1] = var1;
            } else {
                int var1 = m[0];
                for (int i = 0; i < m.length - 1; i++) {
                    var2 = m[i + 1];
                    m[i + 1] = var1;
                    var1 = var2;
                }
                m[0] = var1;
            }
        }
        return m;
    }
}

