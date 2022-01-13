package com.example.algorithm.base;

/**
 * 斐波那契数列
 *
 * @author liugang
 * @create 2022/1/8
 */
public class FibonacciExample {

    public static double fibonacci(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static double fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        double first = 1, second = 2, third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        double result2 = fibonacci2(200);
        System.out.println("result:" + result2);
        double result1 = fibonacci(200);
        System.out.println("result1:" + result1);
    }
}
