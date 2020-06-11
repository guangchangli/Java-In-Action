package com.aladdin.collection.map;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * @author lgc
 */
public class HashMapAction {
    public static void main(String[] args) {
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(Maps.newHashMap());

    }
}
