package com.example.algorithm.search;

/**
 * 二分查找
 *
 * @author liugang
 * @create 2022/1/9
 */
public class BinarySearchExample {

    public static int binarySearch(int[] nums, int key) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            // 中间位置
            int mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (key > nums[mid]) {
                // 从右边找
                start = mid + 1;
            } else {
                // 从左边找
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int result = binarySearch(array, 8);
        System.out.println("result:" + result);
    }
}
