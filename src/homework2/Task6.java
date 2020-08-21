package homework2;

public class Task6 {
    public static void main(String[] args) {
        int[] m = {1,0,1,1,2,3,0,2,1,2,3};

        System.out.println(checkBalance(m));
    }
    public static boolean checkBalance(int[] m){
        for(int j = 0; j < m.length; j++){
            int sumL = 0, sumR = 0;
            for(int i=0; i<=j; i++)
                sumL+=m[i];
            for(int i = j+1; i< m.length; i++)
                sumR+=m[i];
            if(sumL==sumR)
                return true;
        }
        return false;
    }
}
