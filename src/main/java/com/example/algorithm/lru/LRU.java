package com.example.algorithm.lru;

import cn.hutool.core.collection.ListUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * lru算法
 *
 * @author liugang
 * @create 2022/1/7
 */
public class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    protected int maxElements;

    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        maxElements = 6;
    }

    /**
     * 当元素超多6个时，删除最近最少使用的元素
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > maxElements;
    }

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        LRU<String, Integer> lru = new LRU<>(16, 0.75f, true);
        List<String> keys = ListUtil.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        for (String key : keys) {
            lru.put(key, 0);
            System.out.println("size --->：" + lru.size());
        }

        for (Entry<String, Integer> entry : lru.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}
