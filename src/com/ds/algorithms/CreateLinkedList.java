package com.ds.algorithms;

public class CreateLinkedList {

    public static ListNode getLinkedList(int[] nums){
        ListNode head = new ListNode(0);
        ListNode t = head;
        for (int i=0; i<nums.length; ++i){
            t.next = new ListNode(nums[i]);
            t = t.next;
        }
        return head.next;
    }

}
