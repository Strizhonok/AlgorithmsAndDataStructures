package com.structures.linkedlist;

import com.structures.linkedlist.objects.DoublyLinkedNode;
import java.util.Optional;

public class DoublyLinkedList<E> implements List<E> {

    int size = 0;

    private DoublyLinkedNode<E> first;

    private DoublyLinkedNode<E> last;

    @Override
    public boolean addLast(E object) {
        final DoublyLinkedNode<E> lastNode = last;
        final DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(object);
        newNode.setPrev(last);

        last = newNode;
        if (first == null) {
            first = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean set(int index, E object) {
        final DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(object);

        if (index == 0) {
            newNode.setNext(first.getNext());
            if (size > 1) {
                first.getNext().setPrev(newNode);
            }

            first.setValue(null);
            first.setNext(null);
            first = newNode;

            if (size == 1) {
                last = newNode;
            }

            return true;
        } else if (index == size - 1) {
            newNode.setPrev(last.getPrev());
            if (size > 1) {
                last.getPrev().setNext(newNode);
            }

            last.setValue(null);
            last.setPrev(null);
            last = newNode;

            return true;
        } else {
            int currentIndex = 0;
            for (DoublyLinkedNode<E> node = first; node != null; node = node.getNext()) {
                if (currentIndex == index) {
                    final DoublyLinkedNode<E> prevNode = node.getPrev();
                    final DoublyLinkedNode<E> nextNode = node.getNext();

                    prevNode.setNext(newNode);
                    newNode.setPrev(prevNode);

                    nextNode.setPrev(newNode);
                    newNode.setNext(nextNode);

                    node.setValue(null);
                    node.setPrev(null);
                    node.setNext(null);

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
            final DoublyLinkedNode<E> newLastNode = last.getPrev();
            last.setValue(null);
            last.setPrev(null);
            newLastNode.setNext(null);
            last = newLastNode;
            size--;
        }

        return true;
    }

    @Override
    public boolean removeFirst() {
        if (first == null) {
            return false;
        } else if (size == 1) {
            clear();
        } else {
            final DoublyLinkedNode<E> newFirstNode = first.getNext();
            first.setValue(null);
            first.setNext(null);
            newFirstNode.setPrev(null);
            first = newFirstNode;
            size--;
        }

        return true;
    }

    @Override
    public boolean remove(E object) {
        if (first == null) {
            return false;
        } else {
            if (first.getValue().equals(object)) {
                return removeFirst();
            } else if (last.getValue().equals(object)) {
                return removeLast();
            } else {
                for (DoublyLinkedNode<E> node = first; node != null; node = node.getNext()) {
                    if (node.getValue().equals(object)) {
                        final DoublyLinkedNode<E> prevNode = node.getPrev();
                        final DoublyLinkedNode<E> nextNode = node.getNext();

                        node.setValue(null);
                        node.setPrev(null);
                        node.setNext(null);

                        prevNode.setNext(nextNode);
                        nextNode.setPrev(prevNode);

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
        return Optional.ofNullable(first).map(DoublyLinkedNode::getValue).orElse(null);
    }

    @Override
    public E getLast() {
        return Optional.ofNullable(last).map(DoublyLinkedNode::getValue).orElse(null);
    }

    @Override
    public E getValue(int index) {
        return Optional.ofNullable(find(index)).map(DoublyLinkedNode::getValue).orElse(null);
    }

    @Override
    public DoublyLinkedNode<E> find(int index) {
        int currentIndex = 0;
        for (DoublyLinkedNode<E> node = first; node != null; node = node.getNext()) {
            if (currentIndex == index) {
                return node;
            }
            currentIndex++;
        }
        return null;
    }

    @Override
    public DoublyLinkedNode<E> find(E e) {
        for (DoublyLinkedNode<E> node = first; node != null; node = node.getNext()) {
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
        for (DoublyLinkedNode<E> node = first; node != null; ) {
            final DoublyLinkedNode<E> currentNode = node;
            node = node.getNext();

            currentNode.setValue(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (DoublyLinkedNode<E> x = first; x != null; x = x.getNext()) {
            result[i++] = x.getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
            "size=" + size +
            ", first=" + first +
            ", last=" + last +
            '}';
    }

}
