package com.ds.algorithms;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomLinkedList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode origin = pHead;


        // double the list
        // origin1--> new1--> origin2--> new2
        boolean head = false;
        while (origin != null){
            RandomListNode tmp = new RandomListNode(origin.label);
            tmp.next = origin.next;
            origin.next = tmp;
            origin = tmp.next;
        }
        origin = pHead;
        RandomListNode t = origin.next;
        // add the random arrow
        while (origin != null){
            RandomListNode origin_random = origin.random;
            if (origin_random != null)
                t.random = origin_random.next;
            origin = t.next;
            if(origin != null)
                t = origin.next;
        }

        // split the origin and new lists
        t = pHead.next;
        RandomListNode result = t;
        origin = pHead;
        while (t != null && t.next!=null){
            t.next = t.next.next;
            t = t.next;
        }



        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);
        RandomListNode five = new RandomListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        one.random = three;
        two.random = five;
        four.random = two;

        RandomLinkedList r = new RandomLinkedList();
        RandomListNode res = r.Clone(one);
        while (res != null) {
            System.out.println(res.label + "," + res.random);
            res = res.next;
        }

    }
}