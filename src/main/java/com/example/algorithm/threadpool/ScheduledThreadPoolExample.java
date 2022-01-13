package com.example.algorithm.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liugang
 * @create 2022/1/8
 */
public class ScheduledThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        // 提交任务
        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + "延迟2秒");
            }
        }, 1l, 2l, TimeUnit.SECONDS);

        Thread.sleep(1000 * 10);

        // 管理线程池
        scheduledThreadPool.shutdown();
    }
}

