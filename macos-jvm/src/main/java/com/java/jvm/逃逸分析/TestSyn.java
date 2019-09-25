package com.java.jvm.逃逸分析;

public class TestSyn {
    public static void lock(){
        int[] numbers=new int[65];
        synchronized (numbers) {
            numbers[0]=1;
        }
    }
    public static void main(String[] args)   {
        long begin=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            lock();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
