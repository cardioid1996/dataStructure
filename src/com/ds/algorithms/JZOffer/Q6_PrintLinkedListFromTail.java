package com.ds.algorithms.JZOffer;

import com.ds.algorithms.CreateLinkedList;
import com.ds.algorithms.ListNode;

import java.util.Stack;

public class Q6_PrintLinkedListFromTail {
    public static void print(ListNode head){
        if (head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            int tmp = stack.pop();
            if (stack.isEmpty())
                System.out.print(tmp);
            else
                System.out.print(tmp + ",");
        }
    }

    public static void main(String[] args) {
        ListNode head = CreateLinkedList.getLinkedList(new int[]{1});
        print(head);
    }
}
