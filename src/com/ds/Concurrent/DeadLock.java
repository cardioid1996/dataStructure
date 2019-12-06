package com.ds.Concurrent;

import java.util.Arrays;
import java.util.List;
import java.lang.Thread;

public class DeadLock  {
    final List<Integer> list1 = Arrays.asList(1,2,3);
    final List<Integer> list2 = Arrays.asList(3,4,5);
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            synchronized (list1){
                for (int i : list1)
                    System.out.println(list1.get(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list2){
                    for (int i : list2)
                        System.out.println(list2.get(i));
                }
            }
        }
    };

    Thread t1 = new Thread(r1, "t1");

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (list2){
                for (int i : list2)
                    System.out.println(list2.get(i));
                synchronized (list1){
                    for (int i : list1)
                        System.out.println(list1.get(i));
                }
            }
        }
    });


}
