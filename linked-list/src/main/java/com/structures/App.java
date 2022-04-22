package com.structures;

import com.structures.linkedlist.DoublyLinkedList;
import com.structures.linkedlist.List;
import com.structures.linkedlist.SinglyLinkedList;

public class App {

    public static void main(String[] args) {
        List<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addLast("test");
        singlyLinkedList.addLast("single");
        singlyLinkedList.addLast("linked");
        singlyLinkedList.addLast("list");

        List<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addLast("test");
        doublyLinkedList.addLast("doubly");
        doublyLinkedList.addLast("linked");
        doublyLinkedList.addLast("list");
    }

}
