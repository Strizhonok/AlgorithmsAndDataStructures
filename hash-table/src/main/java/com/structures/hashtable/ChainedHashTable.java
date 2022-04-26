package com.structures.hashtable;

import java.util.Objects;

public class ChainedHashTable<K, V> implements HashTable<K, V> {

    private Node<K, V>[] array;
    private int size;
    private int capacity;

    public ChainedHashTable() {
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

        if (Objects.isNull(array[hashIndex])) {
            array[hashIndex] = newNode;
            size ++;
        } else {
            for(Node<K, V> node = array[hashIndex]; node != null; node = node.next) {
                if (node.key == key) {
                    break;
                }
                if (node.next == null) {
                    node.next = newNode;
                    size ++;
                    break;
                }
            }
        }

    }

    @Override
    public void delete(K key) {
        int hashIndex = hashCode(key);

        if (array[hashIndex] == null) {
            return;
        }

        if (array[hashIndex].key.equals(key)) {
            array[hashIndex].key = null;
            array[hashIndex].value = null;

            if (Objects.isNull(array[hashIndex].next)) {
                array[hashIndex] = null;
            } else {
                array[hashIndex] = array[hashIndex].next;
            }
            size--;
        } else {
            for (Node<K, V> node = array[hashIndex]; node != null; node = node.next) {
                if (Objects.isNull(node.next)) {
                    return;
                } else if (node.next.key.equals(key)) {
                    if (Objects.nonNull(node.next.next)) {
                        Node<K, V> nexNode = node.next.next;
                        node.next.key = null;
                        node.next.value = null;
                        node.next = nexNode;
                    } else {
                        node.next.key = null;
                        node.next.value = null;
                        node.next = null;
                    }
                    size--;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int hashIndex = hashCode(key);

        if (array[hashIndex] == null) {
            return null;
        }

        for (Node<K, V> node = array[hashIndex]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
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
            array[hashIndex] = node;
        }
    }

    static class Node<K, V> {

        K key;

        V value;

        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
