package com.java.base.nio;

import sun.misc.Unsafe;

import java.nio.ByteBuffer;

/**
 * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M
 * <p>
 * <p>
 * -XX:+DisableExplicitGC  加此参数就会抛出堆外内存溢出
 */
public class SafeTest {
    public static void main(String[] args) {
//        Unsafe unsafe = Unsafe.getUnsafe();
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
        }
    }
}
