package com.ds.structure;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MinStack{
    private Stack<Integer> st = new Stack<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public void push(int node) {
        st.push(node);
        list.add(node);
        Collections.sort(list);
    }

    public void pop() {
        if (! st.isEmpty()){
            int x = st.pop();
            list.remove((Integer)x);
        }
    }

    public int top() {
        if (!st.isEmpty())
            return st.peek();
        else
            return -1;
    }

    public int min() {
        if (!list.isEmpty())
            return list.get(0);
        else
            return -1;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(3);
        System.out.println(m.min());
        m.push(4);
        System.out.println(m.min());
        m.push(2);
        m.push(3);
        System.out.println(m.min());
        int x = m.top();
        System.out.println(x);
        m.pop();
        System.out.println(m.min());
        m.pop();
        System.out.println(m.min());
        m.pop();
        System.out.println(m.min());
        m.push(0);
        System.out.println(m.min());
    }
}