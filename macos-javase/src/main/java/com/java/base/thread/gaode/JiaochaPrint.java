package com.java.base.thread.gaode;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class JiaochaPrint {
    public static void main(String[] args) {
        while (true) {
            Thread t1 = new Thread(() -> {
                System.out.println("A....");
            });
            t1.start();
            Thread t2 = new Thread(() -> {
                System.out.println("B....");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t2.start();
        }
    }
}
