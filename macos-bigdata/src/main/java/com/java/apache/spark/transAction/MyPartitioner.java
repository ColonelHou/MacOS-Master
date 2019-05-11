package com.java.apache.spark.transAction;

import org.apache.spark.Partitioner;

import java.util.Random;

/**
 * Created by colonelhou on 2019/4/27.
 */
public class MyPartitioner extends Partitioner{
    @Override
    public int numPartitions() {
        return 5;
    }

    @Override
    public int getPartition(Object key) {
        System.out.println("+++++++++++" + key.toString());
        if (key.toString().equals("hello")) {
            return 1;
        }
        return new Random().nextInt(5);
    }
}
