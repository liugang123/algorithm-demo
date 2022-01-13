package com.example.algorithm.base;

import java.util.Objects;

/**
 * 回文串
 *
 * @author liugang
 * @create 2022/1/9
 */
public class PalindromeExample {

    public static boolean isPalindrome(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (!Objects.equals(charArray[i], charArray[charArray.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aabbccfgccbbaa";
        boolean result = isPalindrome(input);
        System.out.println("result:" + result);
    }
}
