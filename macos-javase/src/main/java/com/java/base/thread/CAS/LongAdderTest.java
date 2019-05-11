package com.java.base.thread.CAS;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by colonelhou on 2019/4/26.
 * https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484070&idx=1&sn=c1d49bce3c9da7fcc7e057d858e21d69&chksm=fba6eaa5ccd163b3a935303f10a54a38f15f3c8364c7c1d489f0b1aa1b2ef293a35c565d2fda&scene=21#wechat_redirect
 */
public class LongAdderTest {
    public static void main(String[] args) {
        LongAdder l = new LongAdder();
        l.increment();
    }
}
