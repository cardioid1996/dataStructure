package com.ds.Concurrent;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class ProducerConsumerQueue<T> {

    static AtomicInteger workLoad = new AtomicInteger(100);

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 8;

        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i=0; i<5; ++i){
            service.submit(new Producer(list, capacity));
        }
        for(int i=0; i<5; ++i){
            service.submit(new Consumer(list));
        }
        while (true){
            if (workLoad.get()<=0 && list.isEmpty()){
                service.shutdownNow();
                return;
            }
        }
    }



    // 为什么是静态内部类
    public static class Producer implements Runnable{
        private final LinkedList<Integer> list;
        private final int capacity;

        public Producer(LinkedList<Integer> list, int capacity){
            this.list = list;
            this.capacity = capacity;
        }
        @Override
        public void run(){
            while(workLoad.get() > 0){
                synchronized (list){
                    while (list.size() == capacity){
                        try {
                            list.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    if (workLoad.get() > 0){
                        Integer num = new Random().nextInt();
                        list.add(num);
                        workLoad.decrementAndGet();
                        System.out.println(Thread.currentThread().getName() + " produce " +num + "workload:" + workLoad);
                        list.notifyAll();
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable{
        private final LinkedList<Integer> list;

        public Consumer(LinkedList<Integer> list){
            this.list = list;
        }

        @Override
        public void run(){
            while(true){
                synchronized (list){
                    while (list.isEmpty()){
                        if (workLoad.get()<=0)
                            return;
                        try {
                            list.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    int num = list.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " consume " + num);
                    list.notifyAll();
                    if (workLoad.get()<=0 && list.isEmpty())
                        return;
                }
            }
        }
    }
}
