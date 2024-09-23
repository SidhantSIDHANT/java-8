package com.collection.ConcurrentCollection;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class CopyOnWriteArrayList {

    public void copyOnWriteArray() {
        ConcurrentMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        concurrentHashMap.put("java", 20);
        concurrentHashMap.put("Angular", 123);
        concurrentHashMap.put("javaScript", 222);
        concurrentHashMap.put("php", 256);
        System.out.println(concurrentHashMap);

        concurrentHashMap.forEach((key, value) -> {
            System.out.println("------------ key -----------");
            System.out.println(key);
            System.out.println("-------------Value -------------");
            System.out.println(value);
        });

        Set<ConcurrentMap.Entry<String, Integer>> concurrentSet = concurrentHashMap.entrySet();
        Iterator<ConcurrentMap.Entry<String, Integer>> iterator = concurrentSet.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            Map.Entry<String, Integer> itr = iterator.next();
            String key = itr.getKey();
            Integer value = itr.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static void main(String[] arg) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.copyOnWriteArray();
    }
}