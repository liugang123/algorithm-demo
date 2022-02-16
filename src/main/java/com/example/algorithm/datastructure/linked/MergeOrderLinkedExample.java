package com.example.algorithm.datastructure.linked;


/**
 * 合并两个有序链表
 *
 * @author liugang
 * @create 2022/1/27
 */
public class MergeOrderLinkedExample {

    public static LinkedNode mergeOrderLinked(LinkedNode linked1, LinkedNode linked2) {
        LinkedNode result = new LinkedNode();
        while (linked1 != null && linked2 != null) {
            if (linked1.data <= linked2.data) {
                result.next = linked1;
                linked1 = linked1.next;
            } else {
                result.next = linked2;
                linked2 = linked2.next;
            }
            result = result.next;
        }
        if (linked1 != null) {
            result.next = linked1;
        }
        if (linked2 != null) {
            result.next = linked2;
        }
        return result;
    }

    public static class LinkedNode {
        private int data;
        private LinkedNode next;
    }

    public static void main(String[] args) {

        // 链表1
        LinkedNode linked1 = new LinkedNode();
        linked1.data = 1;
        LinkedNode next11 = new LinkedNode();
        next11.data = 3;
        linked1.next = next11;
        LinkedNode next12 = new LinkedNode();
        next12.data = 5;
        next11.next = next12;

        // 链表2
        LinkedNode linked2 = new LinkedNode();
        linked2.data = 2;
        LinkedNode next21 = new LinkedNode();
        next21.data = 4;
        linked2.next = next21;
        LinkedNode next22 = new LinkedNode();
        next22.data = 6;
        next21.next = next22;

        // 合并链表
        LinkedNode result = mergeOrderLinked(linked1, linked2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

}
