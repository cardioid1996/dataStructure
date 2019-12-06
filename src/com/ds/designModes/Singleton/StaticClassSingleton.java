package com.ds.designModes.Singleton;

public class StaticClassSingleton {
    // 静态内部类
    private static class CreateInstanceClass{
        private static final StaticClassSingleton instance = new StaticClassSingleton();
    }
    // 构造函数
    private StaticClassSingleton(){
    }
    // 对外接口
    public static final StaticClassSingleton getInstance(){
        return CreateInstanceClass.instance;
    }

    public static void main(String[] args) {
        StaticClassSingleton.getInstance();
    }
}


