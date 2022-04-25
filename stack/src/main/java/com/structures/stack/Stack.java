package com.structures.stack;

public class Stack {

    private final int capacity;
    private final String[] array;
    private int top;

    public Stack(int size) {
        this.capacity = size;
        array = new String[capacity];
        top = -1;
    }

    /**
     * Add element to the top of the list
     */
    public boolean push(String element) {
        if (isFull()) {
            return false;
        }
        array[++top] = element;
        return true;
    }

    /**
     * Returns and deletes top element from list
     */
    public String pop () {
        if (isEmpty()) {
            return null;
        }

        return array[top--];
    }

    /**
     * Checks if list is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * Checks if list is full
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Returns element from the top of the list without deleting
     */
    public String peek() {
        return array[top];
    }

}
