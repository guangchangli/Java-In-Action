package com.aladdin.juc.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * sync cas 实现
 * synchronized只锁定当前链表或红黑二叉树的首节点，这样只要hash不冲突，就不会产生并发，效率又提升N倍。
 * @author lgc
 **/
public class ConCurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
