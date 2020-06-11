package com.aladdin.juc.reentrantrw;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lgc
 */
public class Cache {
    static HashMap<String, Object> map = Maps.newHashMapWithExpectedSize(16);
    static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    static Lock r = rw1.readLock();
    static Lock w = rw1.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, String value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
