package com.java.base.thread.gaode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class YieldTwoJiaoCha {
    public static void main(String[] args) {
        Pro p = new Pro();
        Con c = new Con();
        p.setPriority(Thread.MIN_PRIORITY);
        c.setPriority(Thread.MAX_PRIORITY);
//        c.start();
//        p.start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10, 10,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue(10));
        executor.submit(p);
        executor.submit(c);
    }
}
class Pro extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("+++++++++p" + i );
            Thread.yield();
            i ++;
            if (i == 5) {
                break;
            }
        }
    }
}
class Con extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("------------c" + i );
            Thread.yield();
            i ++;
            if (i == 5) {
                break;
            }
        }
    }
}
