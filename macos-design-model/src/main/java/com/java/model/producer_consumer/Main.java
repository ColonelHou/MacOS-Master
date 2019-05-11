package com.java.model.producer_consumer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Main {

    public static void main(String[] args) {
        // 共享数据
        DateQueue dq = new DateQueue();

        // 生产者线程
        Producer p = new Producer(dq);
        // 消费者线程
        Consumer c = new Consumer(dq);

        Thread cc = new Thread(c);
        cc.start();
        Thread pp = new Thread(p);
        pp.start();

        // 多线程生产/消费
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i ++) {
//            service.submit(p);
//            service.submit(c);
//        }

//        p.start();
//        c.start();

    }
}

