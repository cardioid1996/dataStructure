package com.ds.Concurrent;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerQueueCondition {

    private final static LinkedList<Integer> list = new LinkedList<>();
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition full = lock.newCondition();
    private final static Condition empty = lock.newCondition();
    private final static int capacity = 10;
    private volatile static int workload = 100;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0; i<5; ++i)
            service.submit(new Producer());
        for (int i=0; i<5; ++i)
            service.submit(new Consumer());
        while(true){
            if (workload==0 && list.isEmpty()){
                service.shutdownNow();
                return;
            }
        }
    }

    private static class Producer implements Runnable{

        @Override
        public void run(){
            while(workload > 0){
                lock.lock();
                try{
                    while(list.size() == capacity){
                        full.await();
                    }
                    if (workload > 0){
                        Integer num = new Random().nextInt();
                        list.add(num);
                        workload--;
                        System.out.println(Thread.currentThread().getName() + " produce " + num + "workload: " + workload);
                        empty.signal();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Consumer implements Runnable{
        @Override
        public void run(){
            while(list.size()>0 || workload>0){
                try{
                    lock.lock();
                    while (list.size() == 0){
                        if (workload == 0)
                            return;
                        empty.await();
                    }
                    int num = list.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " consume " + num);
                    full.signal();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
