package com.java.base.thread.kechongrusuo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class ReentrantTest implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    public void gg() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        ss();
        lock.unlock();
    }

    private void ss() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        lock.unlock();
    }

    public void run() {
//        get();
        gg();
    }

    public static void main(String[] args) {
        ReentrantTest rt = new ReentrantTest();
        for(;;){
            new Thread(rt).start();
        }
    }
}
