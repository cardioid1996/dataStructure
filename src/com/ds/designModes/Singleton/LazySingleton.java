package com.ds.designModes.Singleton;

public class LazySingleton {
    private static volatile LazySingleton instance = null;
    private LazySingleton(){
    }
    public LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}
