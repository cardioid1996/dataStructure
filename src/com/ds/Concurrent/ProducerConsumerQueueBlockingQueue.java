package com.ds.Concurrent;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerQueueBlockingQueue {

    /** BlockingQueue实现的生产者消费者模式 **/

    private static final LinkedBlockingQueue<Integer> blockinQueue = new LinkedBlockingQueue<>(20);
    private static AtomicInteger workload = new AtomicInteger(100);

    public static void main(String[] args) {

        for (int i=0; i<5; ++i)
            new Thread(new Producer()).start();
        for (int i=0; i<5; ++i)
            new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable{

        @Override
        public void run() {
            while (workload.get() > 0){
                try{
                    if(workload.get()>0){
                        blockinQueue.put(new Random().nextInt());
                        workload.decrementAndGet();
                        System.out.println("produce, workload: " + workload);
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return;
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run(){
            while(!blockinQueue.isEmpty() || workload.get()>0){
                try{
                    int num = blockinQueue.take();
                    System.out.println("consume " + num);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return;
        }
    }

}
