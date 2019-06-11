package com.java.base.thread.gaode;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class JiaochaPrint {
    public static void main(String[] args) {
        int x = 0;
        while (true) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A....");
            });
            t1.start();
            Thread t2 = new Thread(() -> {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B....");
            });
            t2.start();
            x ++;
            if (x == 1) break;
        }
    }
}
