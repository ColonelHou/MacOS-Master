package com.java.base.thread.method;

public class InteruptTest {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run() {
                while (true) {
                    if (Thread.currentThread().interrupted()) {
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("===========t");
                    Thread.yield();
                }
            }
        };
        t.start();
//        Thread.sleep(2000);
        System.out.println("+++++++++++++++main");
        t.interrupt();
    }
}
