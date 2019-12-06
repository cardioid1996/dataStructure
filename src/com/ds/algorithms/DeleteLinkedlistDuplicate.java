package com.ds.algorithms;

import java.util.List;
import java.util.ArrayList;


public class DeleteLinkedlistDuplicate {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;

        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode p = head;
        ListNode t = p;
        while (p.next != null){
            if (p.next.next != null && p.next.val == p.next.next.val){
                t = p.next;
                while (t.next != null && t.val == t.next.val){
                    t = t.next;
                }
                p.next = t.next;
                t.next = null;
            }
            else
                p = p.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
        DeleteLinkedlistDuplicate demo = new DeleteLinkedlistDuplicate();
        int[] nums = {1,1,1,2};
        ListNode h = CreateLinkedList.getLinkedList(nums);
        ListNode res = demo.deleteDuplication(h);
        System.out.println(res);
    }
}