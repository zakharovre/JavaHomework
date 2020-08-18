package homework1;

public class Task8 {
    public static String leap(int a){
        String str = a + " является високосным годом";
        if(a%4!=0 || (a%100==0 && a%400!=0))
            str = a + " является невисокосным годом.";
        return str;
    }
}
