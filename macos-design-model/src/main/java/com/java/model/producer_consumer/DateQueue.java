package com.java.model.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class DateQueue {


    public BlockingQueue<String> queue = new ArrayBlockingQueue(1);

    public synchronized void put(String val) {
        while (queue.size() == 1) {
            try {
                this.wait(); // 让线程暂停, 并让同对象锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        queue.offer(val);
    }

    public synchronized String get() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return queue.poll();
    }
}
