package homework13;

import java.util.Arrays;

public class Task {
    static final int size = 10000000;
    static final int h = size / 2;
    static final float[] arr = new float[size];

    public static void main(String[] args) throws InterruptedException {
        System.out.println(oneThread(arr));
        System.out.println(thoThreads(arr));
    }

    static long oneThread(float[] arr) {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        return System.currentTimeMillis() - a;
    }

    static long thoThreads(float[] arr) throws InterruptedException {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < h; i++)
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++)
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5f) * Math.cos(0.2f + (i + h) / 5f) * Math.cos(0.4f + (i + h) / 2f));
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        return System.currentTimeMillis()-a;
    }
}
