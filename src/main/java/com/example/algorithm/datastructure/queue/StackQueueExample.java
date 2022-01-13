package com.example.algorithm.datastructure.queue;

import java.util.Stack;

/**
 * 栈实现队列
 *
 * @author liugang
 * @create 2022/1/8
 */
public class StackQueueExample {

    public static class StackQueue<T> {
        private Stack<T> in = new Stack<>();
        private Stack<T> out = new Stack<>();

        private void enQueue(T data) {
            in.push(data);
        }

        private T deQueue() {
            if (!out.empty()) {
                return out.pop();
            }
            // 将in全部放入out在出队
            while (!in.empty()) {
                out.push(in.pop());
            }
            return out.pop();
        }
    }

    public static void main(String[] args) {
        StackQueue<String> stackQueue = new StackQueue<>();
        stackQueue.enQueue("1");
        stackQueue.enQueue("2");
        stackQueue.enQueue("3");

        String temp = stackQueue.deQueue();
        System.out.println("dequeue:" + temp);

        stackQueue.enQueue("4");
        stackQueue.enQueue("5");

        for (int i = 0; i < 4; i++) {
            String value = stackQueue.deQueue();
            System.out.println("dequeue:" + value);
        }
    }
}
