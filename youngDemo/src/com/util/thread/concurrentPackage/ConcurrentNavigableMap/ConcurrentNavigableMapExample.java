package com.util.thread.concurrentPackage.ConcurrentNavigableMap;

import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class ConcurrentNavigableMapExample {
    public static void main(String[] args){
        ConcurrentNavigableMap concurrentMap = new ConcurrentSkipListMap() {
            @Override
            public ConcurrentNavigableMap subMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap headMap(Object toKey, boolean inclusive) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap tailMap(Object fromKey, boolean inclusive) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap subMap(Object fromKey, Object toKey) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap headMap(Object toKey) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap tailMap(Object fromKey) {
                return null;
            }

            @Override
            public ConcurrentNavigableMap descendingMap() {
                return null;
            }

            @Override
            public NavigableSet navigableKeySet() {
                return null;
            }

            @Override
            public NavigableSet keySet() {
                return null;
            }

            @Override
            public NavigableSet descendingKeySet() {
                return null;
            }

            @Override
            public Object putIfAbsent(Object key, Object value) {
                return null;
            }

            @Override
            public boolean remove(Object key, Object value) {
                return false;
            }

            @Override
            public boolean replace(Object key, Object oldValue, Object newValue) {
                return false;
            }

            @Override
            public Object replace(Object key, Object value) {
                return null;
            }

            @Override
            public Entry lowerEntry(Object key) {
                return null;
            }

            @Override
            public Object lowerKey(Object key) {
                return null;
            }

            @Override
            public Entry floorEntry(Object key) {
                return null;
            }

            @Override
            public Object floorKey(Object key) {
                return null;
            }

            @Override
            public Entry ceilingEntry(Object key) {
                return null;
            }

            @Override
            public Object ceilingKey(Object key) {
                return null;
            }

            @Override
            public Entry higherEntry(Object key) {
                return null;
            }

            @Override
            public Object higherKey(Object key) {
                return null;
            }

            @Override
            public Entry firstEntry() {
                return null;
            }

            @Override
            public Entry lastEntry() {
                return null;
            }

            @Override
            public Entry pollFirstEntry() {
                return null;
            }

            @Override
            public Entry pollLastEntry() {
                return null;
            }

            @Override
            public Comparator comparator() {
                return null;
            }

            @Override
            public Object firstKey() {
                return null;
            }

            @Override
            public Object lastKey() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };
        concurrentMap.put("1","value1");
        concurrentMap.put("2","value2");
        concurrentMap.put("3","value3");

        ConcurrentNavigableMap headMap = concurrentMap.headMap("2");
        ConcurrentNavigableMap tailMap = concurrentMap.tailMap("2");
        ConcurrentNavigableMap subMap = concurrentMap.subMap("2", "3");
    }
}
