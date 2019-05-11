package com.java.base.thread.juc_Utils;

import java.util.PriorityQueue;

/**
 * Created by colonelhou on 2019/5/6.
 * 优先队列
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(3);
        pq.offer(-6);
        pq.offer(9);
        //打印结果为[-6, 3, 9]
        System.out.println(pq);
        //打印结果为-6
        System.out.println(pq.peek());
        //打印结果为-6
        System.out.println(pq.poll());
    }
}
