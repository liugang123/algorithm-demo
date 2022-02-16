package com.example.algorithm.datastructure.linked;


import java.util.Stack;

/**
 * 反转链表
 *
 * @author liugang
 * @create 2022/1/8
 */
public class ReverseLinkedExample {

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public static LinkedNode reverseLinkedList(LinkedNode head) {
        LinkedNode newList = new LinkedNode();
        while (head.next != null) {
            LinkedNode next = head.next;     // 1,2,3
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    public static LinkedNode reverseLinked(LinkedNode linkedNode) {
        Stack<LinkedNode> stack = new Stack<>();
        stack.push(linkedNode);
        while (linkedNode != null) {
            stack.push(linkedNode);
            linkedNode = linkedNode.next;
        }
        LinkedNode result = new LinkedNode();
        result = stack.pop();
        while (!stack.empty()) {
            result.next = stack.pop();
        }
        return result;
    }

    public static class LinkedNode {
        private Object data;
        private LinkedNode next;
    }

    public static void main(String[] args) {

    }

}
