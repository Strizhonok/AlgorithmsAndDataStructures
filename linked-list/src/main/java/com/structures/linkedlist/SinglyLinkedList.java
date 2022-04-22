package com.structures.linkedlist;

import com.structures.linkedlist.objects.SinglyLinkedNode;
import java.util.Optional;

public class SinglyLinkedList<E> implements List<E>{

    int size = 0;

    private SinglyLinkedNode<E> first;

    private SinglyLinkedNode<E> last;

    @Override
    public boolean addLast(E object) {
        final SinglyLinkedNode<E> newNode = new SinglyLinkedNode<>();
        newNode.setValue(object);

        if (first == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean set(int index, E object) {
        final SinglyLinkedNode<E> newNode = new SinglyLinkedNode<>();
        newNode.setValue(object);

        if (index == 0) {
            newNode.setNext(first.getNext());
            first.setValue(null);
            first.setNext(null);
            first = newNode;

            if (size == 1) {
                last = newNode;
            }

            return true;
        } else {
            int currentIndex = 0;
            for (SinglyLinkedNode<E> node = first; node != null; node = node.getNext()) {
                if (currentIndex + 1 == index) {
                    SinglyLinkedNode<E> removedNode = node.getNext();

                    newNode.setNext(removedNode.getNext());
                    node.setNext(newNode);

                    removedNode.setValue(null);
                    removedNode.setNext(null);

                    if (removedNode.equals(last)) {
                        last = newNode;
                    }

                    return true;
                }
                currentIndex++;
            }
        }

        return false;
    }

    @Override
    public boolean removeLast() {
        if (first == null) {
            return false;
        } else if (size == 1) {
            clear();
        } else {
            for (SinglyLinkedNode<E> node = first; node != null; node = node.getNext()) {
                final SinglyLinkedNode<E> next = node.getNext();
                if (next.equals(last)) {
                    node.setNext(null);
                    next.setValue(null);

                    last = node;
                    size--;

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (first == null) {
            return false;
        } else if (size == 1) {
            clear();
        } else {
            final SinglyLinkedNode<E> newFirstNode = first.getNext();
            first.setValue(null);
            first.setNext(null);
            first = newFirstNode;

            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(E object) {
        if (first == null) {
            return false;
        } else {
            if (first.getValue().equals(object)) {
                removeFirst();
            } else if (last.getValue().equals(object)) {
                removeLast();
            } else {
                for (SinglyLinkedNode<E> node = first; node != null; node = node.getNext()) {
                    final SinglyLinkedNode<E> next = node.getNext();
                    if (next.getValue().equals(object)) {
                        node.setNext(next.getNext());
                        next.setValue(null);
                        next.setNext(null);

                        size--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public E getFirst() {
        return Optional.ofNullable(first).map(SinglyLinkedNode::getValue).orElse(null);
    }

    @Override
    public E getLast() {
        return Optional.ofNullable(last).map(SinglyLinkedNode::getValue).orElse(null);
    }

    @Override
    public E getValue(int index) {
        return Optional.ofNullable(find(index)).map(SinglyLinkedNode::getValue).orElse(null);
    }

    @Override
    public SinglyLinkedNode<E> find(int index) {
        int currentIndex = 0;
        for (SinglyLinkedNode<E> node = first; node != null; node = node.getNext()) {
            if (currentIndex == index) {
                return node;
            }
            currentIndex++;
        }
        return null;
    }

    @Override
    public SinglyLinkedNode<E> find(E e) {
        for (SinglyLinkedNode<E> node = first; node != null; node = node.getNext()) {
            if (node.getValue().equals(e)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (SinglyLinkedNode<E> node = first; node != null; ) {
            final SinglyLinkedNode<E> currentNode = node;
            node = node.getNext();

            currentNode.setValue(null);
            currentNode.setNext(null);
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (SinglyLinkedNode<E> x = first; x != null; x = x.getNext()) {
            result[i++] = x.getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
            "size=" + size +
            ", first=" + first +
            ", last=" + last +
            '}';
    }

}
