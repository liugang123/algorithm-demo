package com.example.algorithm.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏
 *
 * @author liugang
 * @create 2022/1/8
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        int taskCount = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(taskCount);
        for (int i = 0; i < taskCount; i++) {
            CyclicBarrierExample.Writer writer = new CyclicBarrierExample.Writer(cyclicBarrier);
            writer.start();
        }
        System.out.println("all finished");
    }

    public static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ":finished");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":all finished");
        }
    }

}
