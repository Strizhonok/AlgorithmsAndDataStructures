package com.structures.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void givenStack_whenPush_thenSuccess() {
        //Given
        final Stack stack = new Stack(2);

        //When
        stack.push("test1");
        stack.push("test2");

        //Then
        assertThat(stack)
            .isNotNull()
            .matches(Stack::isFull)
            .matches(resultStack -> resultStack.pop().equals("test2"))
            .matches(resultStack -> resultStack.pop().equals("test1"))
            .matches(Stack::isEmpty);
    }

    @Test
    void givenStack_whenPop_thenSuccess() {
        //Given
        final Stack stack = new Stack(2);
        stack.push("test1");
        stack.push("test2");

        //When
        stack.pop();
        stack.pop();

        //Then
        assertThat(stack)
            .isNotNull()
            .matches(Stack::isEmpty);
    }

    @Test
    void givenStack_whenPeek_thenSuccess() {
        //Given
        final Stack stack = new Stack(2);
        stack.push("test1");
        stack.push("test2");

        //When
        stack.peek();

        //Then
        assertThat(stack)
            .isNotNull()
            .matches(Stack::isFull)
            .matches(resultStack -> resultStack.peek().equals("test2"));
    }

    @Test
    void givenStack_whenPopAndPushAndPeek_thenSuccess() {
        //Given
        final Stack stack = new Stack(2);

        //When
        stack.push("test1");
        stack.push("test2");
        stack.peek();
        stack.pop();
        stack.push("test3");

        //Then
        assertThat(stack)
            .isNotNull()
            .matches(Stack::isFull)
            .matches(resultStack -> resultStack.pop().equals("test3"))
            .matches(resultStack -> resultStack.pop().equals("test1"))
            .matches(Stack::isEmpty);
    }

}