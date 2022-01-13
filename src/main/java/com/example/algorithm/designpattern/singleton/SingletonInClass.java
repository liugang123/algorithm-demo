package com.example.algorithm.designpattern.singleton;

/**
 * 静态内部类
 *
 * @author liugang
 * @create 2022/1/8
 */
public class SingletonInClass {

    private static class SingletonHolder {
        private final static SingletonInClass INSTANCE = new SingletonInClass();
    }

    private SingletonInClass() {
    }

    public static SingletonInClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
