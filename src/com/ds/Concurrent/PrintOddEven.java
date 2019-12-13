package Concurrent;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEven {

    // 直接用Integer不行
    static AtomicInteger num = new AtomicInteger(0);

    public static void odd_even_print(){
        Thread t1_odd = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (num){
                        num.addAndGet(1);
                        System.out.println("t1奇数: " + num.get());
                        num.notify();
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2_even = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (num){
                    while (true){
                        num.getAndAdd(1);
                        System.out.println("t2偶数: "+ num.get());
                        if(num.get() == 100)
                            break;
                        num.notify();
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        t1_odd.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2_even.start();
    }

    public static void main(String[] args) {
        PrintOddEven.odd_even_print();
    }
}
