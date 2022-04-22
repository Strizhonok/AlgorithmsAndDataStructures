package com.structures.linkedlist.objects;

import lombok.Data;

@Data
public class DoublyLinkedNode<E> implements Node<E> {

    private E value;

    private DoublyLinkedNode<E> next;

    private DoublyLinkedNode<E> prev;

    @Override
    public String toString() {
        return value.toString();
    }

}
