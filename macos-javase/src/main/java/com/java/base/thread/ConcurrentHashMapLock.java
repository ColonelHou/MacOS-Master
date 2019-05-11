package com.java.base.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class ConcurrentHashMapLock {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key ->  map.computeIfAbsent("BBBB", key2 -> 42)
        );
    }
}
