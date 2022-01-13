package com.example.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author liugang
 * @create 2022/1/9
 */
public class BubbleSortExample {

    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 7, 8, 20, 30, 17, 18, 25};
        int[] result = bubbleSort(array);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
