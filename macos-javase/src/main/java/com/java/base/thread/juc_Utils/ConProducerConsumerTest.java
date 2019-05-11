package com.java.base.thread.juc_Utils;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by colonelhou on 2019/5/6.
 */
public class ConProducerConsumerTest {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private Lock lock = new ReentrantLock();
    //    private Condition notFull = lock.newCondition();
    private Condition condition = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        ConProducerConsumerTest con = new ConProducerConsumerTest();
        Producer producer = con.new Producer();
        Consumer consumer = con.new Consumer();
//        producer.start();
//        consumer.start();
//        Thread.sleep(0);
//        producer.interrupt();
//        consumer.interrupt();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i ++) {
            service.submit(producer);
            service.submit(consumer);
        }
    }


    class Consumer extends Thread {
        public void run() {
            consume();
        }

        volatile boolean flag = true;

        private void consume() {
            while (flag) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空，等待数据");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }
                    queue.poll();                //每次移走队首元素
                    condition.signal();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {
        public void run() {
            produce();
        }

        volatile boolean flag = true;

        private void produce() {
            while (flag) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            condition.await();
                        } catch (InterruptedException e) {
                            flag = false;
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    condition.signal();
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
