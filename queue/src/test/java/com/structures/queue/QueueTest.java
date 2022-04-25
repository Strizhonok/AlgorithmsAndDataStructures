package com.structures.queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void givenQueue_whenAdd_thenSuccess() {
        //Given
        final Queue testQueue = new Queue(2);

        //When
        testQueue.add("test1");
        testQueue.add("test2");

        //Then
        assertThat(testQueue)
            .isNotNull()
            .matches(Queue::isFull)
            .matches(queue -> queue.remove().equals("test1"))
            .matches(queue -> queue.remove().equals("test2"))
            .matches(Queue::isEmpty)
            .matches(queue -> Objects.isNull(queue.remove()));
    }

    @Test
    void givenQueue_whenRemove_thenSuccess() {
        //Given
        final Queue testQueue = new Queue(4);
        testQueue.add("test1");
        testQueue.add("test2");
        testQueue.add("test3");
        testQueue.add("test4");

        //When
        testQueue.remove();
        testQueue.remove();

        //Then
        assertThat(testQueue)
            .isNotNull()
            .matches(Predicate.not(Queue::isFull))
            .matches(queue -> queue.remove().equals("test3"))
            .matches(queue -> queue.remove().equals("test4"))
            .matches(Queue::isEmpty)
            .matches(queue -> Objects.isNull(queue.remove()));
    }

    @Test
    void givenQueue_whenAddAndRemove_thenSuccess() {
        //Given
        final Queue testQueue = new Queue(4);

        //When
        testQueue.add("test1");
        testQueue.add("test2");
        testQueue.remove();
        testQueue.add("test3");
        testQueue.add("test4");
        testQueue.remove();
        testQueue.add("test5");
        testQueue.add("test6");

        //Then
        assertThat(testQueue)
            .isNotNull()
            .matches(Queue::isFull)
            .matches(queue -> queue.remove().equals("test3"))
            .matches(queue -> queue.remove().equals("test4"))
            .matches(queue -> queue.remove().equals("test5"))
            .matches(queue -> queue.remove().equals("test6"))
            .matches(Queue::isEmpty)
            .matches(queue -> Objects.isNull(queue.remove()));
    }

}