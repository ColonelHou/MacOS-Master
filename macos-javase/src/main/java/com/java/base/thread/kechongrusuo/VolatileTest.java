package com.java.base.thread.kechongrusuo;

public class VolatileTest {
    public static boolean ready ;
    private static volatile int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                System.out.println(number);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 50;
        ready = true;
        Thread.sleep(1000 * 10);
    }
}
