package com.java.base.thread.juc_Utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class CountdownLatchTe {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch gener = new CountDownLatch(1);
        CountDownLatch so = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i ++) {
            executorService.submit(() -> {
                    try {
                        System.out.println("准备接受命令");
                        gener.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("士兵  开始执行完任务");
                    so.countDown();
            });
        }



        System.out.println("下达命令");
        gener.countDown();

        System.out.println("等等士兵回应");
        so.await();
        System.out.println("士兵 执行完任务");

    }
}
