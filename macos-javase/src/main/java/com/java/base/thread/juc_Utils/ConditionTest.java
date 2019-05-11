package com.java.base.thread.juc_Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by colonelhou on 2019/5/6.
 */
public class ConditionTest {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();


    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();

        Producer p = conditionTest.new Producer();
        Consumer c = conditionTest.new Consumer();
        c.start();
        p.start();

    }

    class Consumer extends Thread {
        public void run() {
            consume();
        }
        private void consume() {
            try {
                lock.lock();
                System.out.println("我在等一个新信号"+this.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Producer extends Thread {
        public void run() {
            produce();
        }
        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁"+this.currentThread().getName());
//                Thread.sleep(1000 * 10);
                condition.signalAll();
                System.out.println("我发出了一个信号："+this.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}
