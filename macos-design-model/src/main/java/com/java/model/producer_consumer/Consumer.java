package com.java.model.producer_consumer;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Consumer implements Runnable{
//public class Consumer extends Thread{
    private DateQueue m;
    public Consumer(DateQueue target) {
        m = target;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " -----消费 ---> " + m.get());
        }
    }
}
