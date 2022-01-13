package com.example.algorithm.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器
 *
 * @author liugang
 * @create 2022/1/8
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":run");
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":run");
                latch.countDown();
            }
        }).start();

        // 等待两个线程执行完
        System.out.println("等待两个线程执行完");
        latch.await();

        System.out.println("继续执行主线程");
    }

}
