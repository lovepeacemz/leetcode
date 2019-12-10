package com.company.List;

import com.company.List.ListReverse.Node;
/**
 * 给定一个单链表 删除倒数第N个元素 然后返回头结点
 *
 * @author zhangmeng36
 * @date 2019/8/7 下午10:23
 */
public class RemoveNList {
    public static Node remove(Node head,int n){
        if(n <= 0 ){
            return head;
        }
        if(head == null){
            return head;
        }
        // 三指针
        Node fast = head;
        Node slow = head;
        Node pre = null;
        int current = 0;
        // 快指针先走n-1步
        while(fast != null && current < n - 1){
            fast = fast.next;
            current ++;
        }
        // 如果没有倒数第n个
        if(fast == null){
            return head;
        }
        //
        while (fast.next != null){
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // 如果第一个元素正好是目标元素，删除头结点
        if(slow == head){
            head = head.next;
        }
        else {
            // 否则删除当前节点
            pre.next = slow.next;
        }
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(10);
        head.next.next = new Node(100);
        Node result = remove(head, 1);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
