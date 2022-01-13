package com.example.algorithm.datastructure.stack;

import java.util.Stack;

/**
 * 反转字符串
 *
 * @author liugang
 * @create 2022/1/8
 */
public class ReverseStringExample {

    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        for (char item : input.toCharArray()) {
            stack.push(item);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "abcdefg";
        String result = reverseString(input);
        System.out.println("result:" + result);
    }
}
