package com.java.apache.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.io.Charsets;

/**
 * Created by colonelhou on 2019/5/2.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        // 里边主要有: 1. 二进制向量数组; 2. hash函数
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 10000000, 0.00001);
        for (int i = 0; i < 10000000; i ++) {
            bloomFilter.put("ab" + i); // 这里把数据库中数据缓存到 过虑器中
        }

        long errorCount = 0;
        // 查1000万中不存在的数据误判率
        for (int i = 0; i < 10000000; i ++) {
            if (bloomFilter.mightContain("abc" + i)) {
                errorCount ++;
            }
        }
        System.out.println(errorCount);
    }
}
