package com.structures.linkedlist;

import com.structures.linkedlist.objects.Node;

public interface List<E> {

    /**
     * Appends the specified element to the end of this list.
     */
    boolean addLast(E object);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    boolean set(int index, E object);

    /**
     * Removes the element from the end of this list.
     */
    boolean removeLast();

    /**
     * Removes the element from the start of this list.
     */
    boolean removeFirst();

    /**
     * Removes the element from this list.
     */
    boolean remove(E object);

    /**
     * Returns first element from this collection.
     */
    E getFirst();

    /**
     * Returns last element from this collection.
     */
    E getLast();

    /**
     * Returns the value at the specified position in this list.
     *
     * @param index index of the element
     */
    E getValue(int index);

    /**
     * Returns element at the specified position
     */
    Node<E> find(int index);

    /**
     * Returns element of list by specified value
     *
     * @param e value from list
     */
    Node<E> find(E e);

    /**
     * Returns size of list.
     */
    int size();

    /**
     * Clears list
     */
    void clear();

    /**
     * Returns array with values from this list
     */
    Object[] toArray();

}
