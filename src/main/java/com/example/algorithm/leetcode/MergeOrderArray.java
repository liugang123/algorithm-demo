package com.example.algorithm.leetcode;

/**
 * 归并排序
 *
 * @author liugang
 * @create 2022/1/13
 */
public class MergeOrderArray {

    public static int[] mergeOrderArray(int[] num1, int[] num2) {
        int i = num1.length - 1, j = num2.length - 1;
        int k = num1.length + num2.length;
        int[] array = new int[k];
        while (i >= 0 && j >= 0) {
            if (num1[i] >= num2[j]) {
                array[--k] = num1[i--];
            } else {
                array[--k] = num2[j--];
            }
        }
        while (i >= 0) {
            array[--k] = num1[i--];
        }
        while (j >= 0) {
            array[--k] = num2[j--];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 6, 7, 9, 16, 25, 34}, num2 = {2, 3, 4, 6, 8, 10, 15, 30};
        int[] result = mergeOrderArray(num1, num2);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
