package com.java.model.producer_consumer;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Producer implements Runnable{
//public class Producer extends Thread{
    private DateQueue m;
    public Producer(DateQueue target) {
        m = target;
    }

    @Override
    public void run() {
        long x = 0;
        while (true) {
            x ++;
            System.out.println(Thread.currentThread().getName() + " ---生成-----" + x);
            m.put("abc -> " + x );
        }
    }
}
