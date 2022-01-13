package com.example.algorithm.sort;

/**
 * 选择排序
 *
 * @author liugang
 * @create 2022/1/9
 */
public class SelectSortExample {

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 7, 8, 20, 30, 17, 18, 25};
        int[] result = selectSort(array);
        for (int item : result) {
            System.out.println(item);
        }
    }

}
