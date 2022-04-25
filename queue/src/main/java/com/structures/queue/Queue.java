package com.structures.queue;

public class Queue {

    private final int capacity;
    private final String[] array;
    private int head;
    private int tail;

    public Queue(int size) {
        this.capacity = size;
        array = new String[capacity];
        head = tail = -1;
    }

    /**
     * Add element to the top of the list
     */
    public boolean add(String element) {
        if (isFull()) {
            return false;
        }

        tail = head == -1 ? 0 : (tail + 1) % capacity;
        head = head == -1 ? 0 : head;
        array[tail] = element;
        return true;
    }

    /**
     * Returns and deletes top element from list
     */
    public String remove () {
        if (isEmpty()) {
            return null;
        }

        if (head == tail) {
            final String value = array[tail];
            head = tail = -1;
            return value;
        } else {
            final String value = array[head];
            head = (head + 1) % capacity;
            return value;
        }
    }

    /**
     * Checks if list is empty
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks if list is full
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

}
