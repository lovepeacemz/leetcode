package com.company.List;

import java.util.PriorityQueue;

/**
 * // 给定一个链表 1->2->3 +add(num)
 * @author zhangmeng36
 * @date 2019/8/7 下午9:40
 */
public class ListReverse {

    protected static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }


    public static Node reverse(Node head){
        Node pre = null;
        Node current = null;
        Node pNext = null;

        current = head;
        while(current != null){
            pNext = current.next;
            current.next = pre;
            pre = current;
            current = pNext;
        }
        return pre;
    }

    public static Node add(Node prt, int m){
        // 反转链表 找到个位开始计算
        Node head = reverse(prt);
        int jinwei = m, temp;
        Node pre = null;
        Node current = null;
        Node pNext = null;

        // 计算进位 并且反转链表
        current = head;
        while(current != null){
            pNext = current.next;
            temp = current.val + jinwei;
            current.val = temp % 10;
            jinwei = temp / 10;
            current.next = pre;
            pre = current;
            current = pNext;
        }
        // 边界条件判断
        if(jinwei > 0){
            Node node = new Node(jinwei);
            node.next = pre;
            return node;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        Node result = add(head, 1);

        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
        int[] nums = new int[]{1,2};
        PriorityQueue<int []> priorityQueue = new PriorityQueue((o1, o2) -> {return 0;});
    }
}
