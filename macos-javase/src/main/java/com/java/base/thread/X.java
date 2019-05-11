package com.java.base.thread;

import java.util.concurrent.*;

/**
 * Created by colonelhou on 2019/4/21.
 * 限制获取某种资源的线程数量
 */
public class X {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), new MyRejected());
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 任务1" );
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 任务2" );
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "任务3" );
        });
        executor.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "任务4" );
        });
        executor.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "任务5" );
        });
        executor.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "任务6" );
        });
        executor.shutdown();

    }
}

class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理....");
        System.out.println("当前被拒绝任务为 : " + r.toString());

    }
}

