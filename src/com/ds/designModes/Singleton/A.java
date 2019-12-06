package com.ds.designModes.Singleton;


import com.ds.designModes.Singleton.HungrySingleton;

public class A {
    public A(){}


    public static void main(String[] args) {
        Class<? extends HungrySingleton> cl = HungrySingleton.getInstance().getClass();
        try{
            HungrySingleton e = cl.newInstance();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
