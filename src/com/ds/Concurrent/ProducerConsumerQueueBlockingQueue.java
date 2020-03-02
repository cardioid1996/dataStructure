package com.ds.Concurrent;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerQueueBlockingQueue {

    /** BlockingQueue实现的生产者消费者模式 **/

    public static void main(String[] args) {

        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {
            while(true){
                try {
                    //blockingQueue.put(ItemFactory.createItem());
                    blockingQueue.put(new Object());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        for (int i=0; i<5; ++i)
            new Thread(producer).start();

        final Runnable consumer = () -> {
            while(true){
                try {
                    Object item = blockingQueue.take();
                    // process(item);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        for (int i=0; i<5; ++i)
            new Thread(consumer).start();

    }

}
