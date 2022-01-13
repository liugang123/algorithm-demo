package com.example.algorithm.designpattern.singleton;

/**
 * 懒汉式
 *
 * @author liugang
 * @create 2022/1/8
 */
public class SingletonLazy {

    private volatile static SingletonLazy INSTANCE = null;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }
}
