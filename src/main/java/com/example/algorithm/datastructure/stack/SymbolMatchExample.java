package com.example.algorithm.datastructure.stack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * 匹配括号
 *
 * @author liugang
 * @create 2022/1/8
 */
public class SymbolMatchExample {

    public static boolean isMatch(String input) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char item : input.toCharArray()) {
            if (!map.containsKey(item) && !map.values().contains(item)) {
                continue;
            }
            if (map.values().contains(item)) {
                stack.push(item);
                continue;
            }
            char temp = stack.empty() ? '#' : stack.pop();
            if (!Objects.equals(temp, map.get(item))) {
                return false;
            }
        }
        System.out.println("stack size:" + stack.size());
        return stack.empty();
    }

    public static void main(String[] args) {
        String input = "[***]hsduwdbdb}";
        boolean result = isMatch(input);
        System.out.println("result:" + result);
    }
}
