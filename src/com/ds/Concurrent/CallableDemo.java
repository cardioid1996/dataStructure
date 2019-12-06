package com.ds.Concurrent;

import java.util.concurrent.*;
import java.util.*;


public class CallableDemo
{
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0; i<10; ++i){
            results.add(exe.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs:results)
            try{
                System.out.println(fs.get());
            }   catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
                return;
            }finally {
                exe.shutdown();
            }
    }
}

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    public String call(){
        return "result of TaskWithResult: " + id;
    }
}
