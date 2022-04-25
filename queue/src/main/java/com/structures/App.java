package com.structures;

import com.structures.queue.Queue;

public class App {

    public static void main(String[] args) {
        final Queue queue = new Queue(5);
        queue.add("provide");
        queue.add("test");
        queue.add("queue");
        queue.add("to");
        queue.remove();
        queue.add("check");
        queue.add("implementation");
    }

}
