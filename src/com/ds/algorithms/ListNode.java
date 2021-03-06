package com.ds.algorithms;

public class ListNode {
    public int val;
    public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public int getVal(){
        return val;

    }
    @Override
    public String toString(){
        String res = Integer.toString(getVal());
        if (next != null)
            res = res + "," + next.toString();
        return res;
    }
}