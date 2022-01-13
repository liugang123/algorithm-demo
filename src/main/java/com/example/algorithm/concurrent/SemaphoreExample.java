package com.example.algorithm.concurrent;


import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author liugang
 * @create 2022/1/8
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        int taskCount = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < taskCount; i++) {
            new Worker(i, semaphore).start();
        }
    }

    public static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人：" + this.num + "，使用机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("工人：" + this.num + "，释放机器");
            }

        }
    }

}
