package com.java.algorithm.datastruct;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by colonelhou on 2019/4/22.
 */
public class X {
    public static void main(String[] args) throws FileNotFoundException {
        long x = 90;
        String s = String.valueOf(x);
        byte b [] = s.getBytes();
        System.out.println(Arrays.toString(b));
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(x);
        System.out.println(buffer.toString());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
    }
}
