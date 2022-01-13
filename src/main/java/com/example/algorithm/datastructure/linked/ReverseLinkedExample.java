package com.example.algorithm.datastructure.linked;

import java.util.Stack;

/**
 * 反转链表
 *
 * @author liugang
 * @create 2022/1/8
 */
public class ReverseLinkedExample {

    public static LinkedNode reverseLinked(LinkedNode linkedNode) {
        Stack<LinkedNode> stack = new Stack<>();
        stack.push(linkedNode);
        while (linkedNode.next != null) {
            stack.push(linkedNode);
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
