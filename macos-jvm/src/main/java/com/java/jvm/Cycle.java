package com.java.jvm;

/**
 * Created by colonelhou on 2019/5/5.
 */
public class Cycle {
    public static void main(String[] args) throws InterruptedException {
        /*ong x = 1000 * 900000;
        Thread.sleep(x);*/


        int end = Integer.MAX_VALUE; //定义个循环终止数，可以无限大,区别于int型。
        int start = end-50;     //定义起始值
        int count = 0;        //初始值
        for(int i=start;i<=end;i++) { //循环体
            count++;         //循环计数
        }
    }
}
