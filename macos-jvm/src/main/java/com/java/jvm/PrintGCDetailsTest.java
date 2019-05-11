package com.java.jvm;

/**
 * Created by colonelhou on 2019/4/22.
 * -XX:+PrintGCDetails
 */
public class PrintGCDetailsTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation4;
        allocation1 = new byte[900900 * 1024];
//        allocation2 = new byte[900000 * 1024];
//        allocation4 = new byte[900000 * 1024];
        byte [] allocation3 = new byte[900000 * 1024];
    }
}
