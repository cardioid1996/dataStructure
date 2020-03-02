package com.ds.Concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerQueueCondition<E> {

    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public ProducerConsumerQueueCondition(int size){
        queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E element){
        lock.lock();
        try{
            while (queue.size() == max){
                notFull.await();
            }
            queue.add(element);
            notEmpty.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public E take(){
        E element = null;
        lock.lock();
        try{
            while(queue.isEmpty()){
                notEmpty.await();
            }
            element = queue.remove();
            notFull.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            return element;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerQueueCondition<Object> pc = new ProducerConsumerQueueCondition<>(10);

        final Runnable producer = ()->{
            while(true){
                pc.put(new Object());
            }
        };

        int producer_num = 3;
        for (int i=0; i<producer_num; ++i)
            new Thread(producer).start();

        final Runnable consumer = ()->{
            while(true){
                Object item = pc.take();
                // process(item)
            }
        };

        int consumer_num = 3;
        for (int i=0; i<consumer_num; ++i)
            new Thread(consumer).start();
    }
}
