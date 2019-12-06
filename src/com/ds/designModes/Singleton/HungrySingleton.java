package com.ds.designModes.Singleton;

public class HungrySingleton {

    // 用静态域存储唯一实例
    private static final HungrySingleton instance = new HungrySingleton();

    // 私有构造方法
    private HungrySingleton(){
    }

    // 提供一个对外访问接口
    public final static HungrySingleton getInstance(){
        return instance;
    }
}