package com.java.base.thread.method;

public class BadSuspend {
    public static Object u = new Object();
    public static class ChangeObjThread extends Thread {
        ChangeObjThread(String name) {
            super.setName(name);
        }
        public void run() {
            synchronized (u) {
                System.out.println("in........" + getName());
                Thread.currentThread().suspend();
                System.out.println("out........" + getName());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ChangeObjThread t1 = new ChangeObjThread("t1==");
        ChangeObjThread t2 = new ChangeObjThread("t2==");
        t1.start();
        Thread.sleep(200);
        t2.resume();
        t2.start();

        t1.resume();
        t1.join();
        t2.join();
    }
}
