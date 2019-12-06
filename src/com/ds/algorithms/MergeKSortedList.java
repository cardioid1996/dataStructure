package com.ds.algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        return recurse(lists, 0, lists.length-1);
    }


    public static ListNode recurse(ListNode[] lists, int l, int r){
        if (l > r)
            return null;
        else if (l == r)
            return lists[l];
        else{
            // l<r
            if (l == r-1){
                // merge two sorted list
                return mergeTwoLists(lists[l], lists[r]);
            }
            else{
                // the gap between l and r > 1
                int mid = l + (r-l)/2;
                ListNode l1 = recurse(lists, l, mid);
                ListNode l2 = recurse(lists, mid+1, r);
                return mergeTwoLists(l1, l2);
            }

        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode t = res;
        while (l1 != null && l2!=null){
            if (l1.val < l2.val){
                t.next = l1;
                l1 = l1.next;
                t = t.next;
            }
            else{
                t.next = l2;
                l2 = l2.next;
                t = t.next;
            }
        }
        if (l1 != null){
            t.next = l1;
        }
        if (l2 != null)
            t.next = l2;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[7];
        list[0] = CreateLinkedList.getLinkedList(new int[]{-10, -9, -9, -3, -1, -1, 0});
        list[1] = CreateLinkedList.getLinkedList(new int[]{-5});
        list[2] = CreateLinkedList.getLinkedList(new int[]{-4});
        list[3] = CreateLinkedList.getLinkedList(new int[]{-8});
        list[4] = CreateLinkedList.getLinkedList(new int[]{});
        list[5] = CreateLinkedList.getLinkedList(new int[]{-9,-6,-5,-4,-2,2,3});
        list[6] = CreateLinkedList.getLinkedList(new int[]{-3,-3,-2,-1,0});
        ListNode res = mergeKLists(list);
        while (res.next != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
