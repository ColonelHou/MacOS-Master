package com.java.base.nio;

import java.nio.ByteBuffer;

/**
 * Created by colonelhou on 2019/4/22.
 */
public class LongToByte {
    public static void main(String[] args) {
        long x = 90;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(x);
        System.out.println(buffer);
    }
}
