package com.java.base.thread.pool;


import java.util.concurrent.*;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, 2,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), new MyRejected());

        pool.submit(new MyTask(1, "任务1"));
        pool.submit(new MyTask(1, "任务2"));
        pool.submit(new MyTask(1, "任务3"));
        pool.submit(new MyTask(1, "任务4"));
        pool.submit(new MyTask(1, "任务5"));
        pool.submit(new MyTask(1, "任务6"));
        pool.shutdown();
    }
}

class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理....");
        System.out.println("当前被拒绝任务为 : " + r.toString());
    }
}
