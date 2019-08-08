package com.java.base.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        RandomAccessFile buffer = new RandomAccessFile("/Users/houningning/Documents/mywksp/MacOS-Master/macos-javase/src/main/java/com/java/base/io/内存映射文件.md", "rw");
        FileChannel channel =  buffer.getChannel();
        System.out.println(System.getProperty("line.separator"));
        CharBuffer charBuffer = null;
        System.out.println(buffer.length());
        MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length());
        charBuffer = Charset.forName("UTF-8").decode(mbb);
        Scanner sc = new Scanner(charBuffer).useDelimiter(System.getProperty("line.separator"));
        while (sc.hasNext()) {
            System.out.println("按行输出----> " + sc.next());
        }
        sc.close();
        System.out.println(charBuffer);
    }
}
