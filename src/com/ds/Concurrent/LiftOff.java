package com.ds.Concurrent;

public class LiftOff implements Runnable {
    private int countdown = 10;
    private static int taskCount = 0;
    private final int taskid = taskCount++;

    public LiftOff(){
        System.out.println("task" + taskid + " start");
    }

    public LiftOff(int c){
        System.out.println("task" + taskid + " start");
        countdown = c;
    }

    public void status(){
        System.out.print(countdown+"("+taskid+")"+" ");
    }
    @Override
    public void run() {
        while (countdown > 0) {
            status();

            countdown--;
            Thread.yield();
        }
        System.out.println("task" + taskid + " over");

    }

    public static void main(String[] args) {
        for (int i=0; i<3; ++i){
            Thread t = new Thread(new LiftOff(10));
            t.start();
        }

    }
}
