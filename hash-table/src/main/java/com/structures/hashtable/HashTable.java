package com.structures.hashtable;

public interface HashTable<K, V> {

    void add(K key, V value);

    void delete(K key);

    V get(K key);

    boolean isEmpty();

    int size();

    int hashCode(K key);

    boolean needToBeIncreased();

}
