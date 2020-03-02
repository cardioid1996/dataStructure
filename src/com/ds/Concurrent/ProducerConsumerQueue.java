package com.ds.Concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerQueue<E> {

    private Queue<E> queue;
    private int max = 16;
    private Object notFull;
    private Object notEmpty;

    public ProducerConsumerQueue(int size){
        queue = new LinkedList<>();
        this.max = size;
        notFull = new Object();
        notEmpty = new Object();
    }

    public synchronized void put(E element){
        while(queue.size() == max){
            try {
                notFull.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        queue.add(element);
        notEmpty.notifyAll();
    }

    public synchronized E take(){
        while(queue.size()==0){
            try {
                notEmpty.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        E element = queue.remove();
        notFull.notifyAll();
        return element;
    }


    public static void main(String[] args) {
        ProducerConsumerQueue<Object> pc = new ProducerConsumerQueue(10);

        final Runnable producer = ()->{
            while(true)
                pc.put(new Object());
        };

        final Runnable consumer = ()->{
            while(true){
                Object obj = pc.take();
                // process(obj)
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }


}
