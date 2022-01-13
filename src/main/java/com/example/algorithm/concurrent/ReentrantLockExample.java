package com.example.algorithm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁
 *
 * @author liugang
 * @create 2022/1/8
 */
public class ReentrantLockExample {

    int temp = 0;

    private Lock lock = new ReentrantLock(true);

    private Condition condition = lock.newCondition();

    public void consumer() {
        try {
            lock.lock();
            // 等待
            System.out.println(Thread.currentThread().getName() + ":await");
            condition.await();
            System.out.println("consumer:" + Thread.currentThread().getName() + ":" + temp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void provider() {
        try {
            lock.lock();
            System.out.println("provider:" + Thread.currentThread().getName() + ":" + "single:" + temp);
            temp++;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPoolConsumer = Executors.newFixedThreadPool(10);
        ScheduledExecutorService singleProvider = Executors.newScheduledThreadPool(1);
        ReentrantLockExample lockExample = new ReentrantLockExample();

        threadPoolConsumer.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lockExample.consumer();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lockExample.consumer();
                }
            }
        }).start();

        singleProvider.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                lockExample.provider();
            }
        }, 2, 2, TimeUnit.SECONDS);
    }

}
