package com.java.base.thread.method;

/**
 * 1. 线程调用 对象的wait是 线程进入对象等待队列;
 *    其他线程调用notify唤醒, 唤醒哪个不确定(非公平)
 * 2. 调用wait/notify必须先获取对象监视器(执行wait/notify会释放这个监视器)
 *
 * 参考生产者消费者模式
 */
public class WaitNotify {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.suspend();
        t.resume();
    }
}
