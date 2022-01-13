package com.example.algorithm.designpattern.singleton;


/**
 * 单列模式--恶汉式
 *
 * @author liugang
 * @create 2022/1/8
 */
public class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
