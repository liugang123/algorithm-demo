package com.example.algorithm.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liugang
 * @create 2022/1/8
 */
public class FixedThreadPoolExample {

    public static void main(String[] args) throws Exception {
        int taskCount = 10;
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(taskCount);

        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            // 创建任务
            int temp = i;
            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    return Thread.currentThread().getName() + ":" + temp;
                }
            };

            // 线程返回值
            Future future = threadPool.submit(callable);
            futureList.add(future);
        }

        // 关闭线程池
        threadPool.shutdown();

        // 变量返回值
        for (Future future : futureList) {
            System.out.println("res:" + future.get());
        }
    }
}
