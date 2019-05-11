package com.java.base.thread.juc_Utils;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        //另外的子线程
        new Thread(() ->{
                try {
                    System.out.println(Thread.currentThread().getName() + ",19");
                    System.out.println(1);
                    c.await();
                } catch (Exception e) {
                }
        }).start();

        //main线程
        try {
            System.out.println(Thread.currentThread().getName() + ",28");
            System.out.println(2);
            c.await();
        } catch (Exception e) {
        }

    }

    //所有线程都到达时，最后一个到达的线程触发Runnable运行
    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",run");
            System.out.println(3);
        }
    }
}
