package com.structures.linkedlist.objects;

import lombok.Data;

@Data
public class SinglyLinkedNode<E> implements Node<E> {

    private E value;

    private SinglyLinkedNode<E> next;

}
