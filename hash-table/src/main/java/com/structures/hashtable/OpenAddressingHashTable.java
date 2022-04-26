package com.structures.hashtable;

import java.util.Objects;

public class OpenAddressingHashTable<K, V> implements HashTable<K, V> {

    private Node<K, V>[] array;
    private int size;
    private int capacity;

    public OpenAddressingHashTable() {
        size = 0;
        capacity = 25;
        array = new Node[capacity];
    }

    @Override
    public void add(K key, V value) {
        final Node<K, V> newNode = new Node<>(key, value);
        int hashIndex = hashCode(key);

        if (needToBeIncreased()) {
            rebuildHashTable();
        }

        while(Objects.nonNull(array[hashIndex])) {
            hashIndex = (hashIndex + 1) % capacity;
        }

        array[hashIndex] = newNode;
        size++;
    }

    @Override
    public void delete(K key) {
        int hashIndex = hashCode(key);

        while (Objects.nonNull(array[hashIndex])) {
            if (Objects.nonNull(array[hashIndex]) && array[hashIndex].key.equals(key)) {
                array[hashIndex] = null;
                size--;
                break;
            }

            hashIndex = (hashIndex + 1) % capacity;
        }
    }

    @Override
    public V get(K key) {
        int hashIndex = hashCode(key);

        while (Objects.nonNull(array[hashIndex])) {
            if (array[hashIndex].key.equals(key)) {
                return array[hashIndex].value;
            }

            hashIndex = (hashIndex + 1) % capacity;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int hashCode(K key) {
        return Objects.hashCode(key) % capacity;
    }

    @Override
    public boolean needToBeIncreased() {
        return (100 * size / capacity) > 80;
    }

    private void rebuildHashTable() {
        final Node<K, V>[] tmpArray = array;

        capacity = capacity * 2;
        array = new Node[capacity * 2];

        for (Node<K, V> node : tmpArray) {
            int hashIndex = hashCode(node.key);

            while(Objects.nonNull(array[hashIndex])) {
                hashIndex = (hashIndex + 1) % capacity;
            }

            array[hashIndex] = node;
        }

    }

    static class Node<K, V> {

        K key;

        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


}
