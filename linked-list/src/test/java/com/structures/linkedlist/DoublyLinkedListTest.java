package com.structures.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import com.structures.linkedlist.objects.SinglyLinkedNode;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void givenStringObjectAndEmptyList_whenAddLast_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        final String newElement = "test";

        //When
        testList.addLast(newElement);

        //Then
        assertThat(testList)
            .isNotNull()
            .matches(list -> list.size() == 1)
            .matches(list -> list.getFirst().equals(newElement))
            .matches(list -> list.getLast().equals(newElement));
    }

    @Test
    void givenStringObjectAndNotEmptyList_whenAddLast_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("addLast");
        int startSize = testList.size();
        final String newElement = "test";

        //When
        testList.addLast(newElement);

        //Then
        assertThat(testList)
            .isNotNull()
            .matches(list -> list.size() == startSize + 1)
            .matches(list -> list.getLast().equals(newElement));
    }

    @Test
    void givenEmptyList_whenSet_thenReturnFalse() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        final String newElement = "test";

        //When
        final boolean result = testList.set(2, newElement);

        //Then
        assertThat(result).isFalse();
        assertThat(testList)
            .matches(list -> list.size() == 0)
            .matches(list -> list.getFirst() == null)
            .matches(list -> list.getLast() == null);
    }

    @Test
    void givenList_whenSet_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("???");
        testList.addLast("test");
        int startSize = testList.size();
        final String newElement = "set()";

        //When
        final boolean result = testList.set(4, newElement);

        //Then
        assertThat(result).isTrue();
        assertThat(testList)
            .matches(list -> list.size() == startSize)
            .matches(list -> list.getValue(4).equals(newElement));
    }

    @Test
    void givenList_whenSetToIndexGreaterThanListSize_thenReturnFalse() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("???");
        testList.addLast("test");
        int startSize = testList.size();
        final String newElement = "ready";

        //When
        final boolean result = testList.set(10, newElement);

        //Then
        assertThat(result).isFalse();
        assertThat(testList)
            .matches(list -> list.size() == startSize)
            .matches(list -> list.find(newElement) == null);
    }

    @Test
    void givenEmptyList_whenRemoveLast_thenReturnFalse() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final boolean result = testList.removeLast();

        //Then
        assertThat(result).isFalse();
        assertThat(testList).matches(list -> list.size() == 0);
    }

    @Test
    void givenList_whenRemoveLast_thenSuccess() {
        //Given
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        final String lastElement = "remove";
        testList.addLast(lastElement);
        int startSize = testList.size();

        //When
        final boolean result = testList.removeLast();

        //Then
        assertThat(result).isTrue();
        assertThat(testList)
            .matches(list -> list.size() == startSize - 1)
            .matches(list -> list.find(lastElement) == null)
            .matches(list -> list.find("check").getNext() == null);
    }

    @Test
    void givenEmptyList_whenRemoveFirst_thenReturnFalse() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final boolean result = testList.removeFirst();

        //Then
        assertThat(result).isFalse();
        assertThat(testList).matches(list -> list.size() == 0);
    }

    @Test
    void givenList_whenRemoveFirst_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        final String firstElement = "new";
        testList.addLast(firstElement);
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("remove");
        int startSize = testList.size();

        //When
        final boolean result = testList.removeFirst();

        //Then
        assertThat(result).isTrue();
        assertThat(testList)
            .matches(list -> list.size() == startSize - 1)
            .matches(list -> list.find(firstElement) == null)
            .matches(list -> list.getFirst().equals("linked list"));
    }

    @Test
    void givenEmptyList_whenRemove_thenReturnFalse() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final boolean result = testList.remove("test");

        //Then
        assertThat(result).isFalse();
        assertThat(testList).matches(list -> list.size() == 0);
    }

    @Test
    void givenList_whenRemove_thenSuccess() {
        //Given
        final String testObject = "check";
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast(testObject);
        testList.addLast("remove");
        int startSize = testList.size();

        //When
        final boolean result = testList.remove(testObject);

        //Then
        assertThat(result).isTrue();
        assertThat(testList)
            .matches(list -> list.size() == startSize - 1)
            .matches(list -> list.find(testObject) == null)
            .matches(list -> list.find("to").getNext().getValue().equals("remove"));
    }

    @Test
    void givenEmptyList_whenGetFirst_thenReturnNull() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final String resultValue = testList.getFirst();

        //Then
        assertThat(resultValue).isNull();
    }

    @Test
    void givenList_whenGetFirst_thenSuccess() {
        //Given
        final String firstValue = "new";
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast(firstValue);
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("getFirst()");

        //When
        final String resultValue = testList.getFirst();

        //Then
        assertThat(resultValue)
            .isNotNull()
            .isEqualTo(firstValue);
    }

    @Test
    void givenEmptyList_whenGetLast_thenReturnNull() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final String resultValue = testList.getLast();

        //Then
        assertThat(resultValue).isNull();
    }

    @Test
    void givenList_whenGetLast_thenSuccess() {
        //Given
        final String lastValue = "getFirst()";
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast(lastValue);

        //When
        final String resultValue = testList.getLast();

        //Then
        assertThat(resultValue)
            .isNotNull()
            .isEqualTo(lastValue);
    }

    @Test
    void givenListWithOneElement_thenGetFirstAndGetLastAndGetByIndexAreEqual() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");

        //When
        final String firstValue = testList.getFirst();
        final String lastValue = testList.getLast();
        final String valueByIndex = testList.getValue(0);

        //Then
        assertThat(firstValue)
            .isEqualTo(lastValue)
            .isEqualTo(valueByIndex);
    }

    @Test
    void givenEmptyList_whenGetValue_thenReturnNull() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final String resultValue = testList.getValue(2);

        //Then
        assertThat(resultValue).isNull();
    }

    @Test
    void givenEmptyList_whenFindByIndex_thenReturnNull() {
        //Given
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();

        //When
        final SinglyLinkedNode<String> result = testList.find(2);

        //Then
        assertThat(result).isNull();
    }

    @Test
    void givenList_whenFindByIndex_thenSuccess() {
        //Given
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("find()");

        //When
        final SinglyLinkedNode<String> result = testList.find(1);

        //Then
        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo("linked list");
    }

    @Test
    void givenEmptyList_whenFindByValue_thenReturnNull() {
        //Given
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();

        //When
        final SinglyLinkedNode<String> result = testList.find("test");

        //Then
        assertThat(result).isNull();
    }

    @Test
    void givenList_whenFindByValue_thenSuccess() {
        //Given
        final SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("find()");

        //When
        final SinglyLinkedNode<String> result = testList.find("linked list");

        //Then
        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo("linked list");
    }

    @Test
    void givenEmptyList_whenSize_thenReturnZero() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        final int size = testList.size();

        //Then
        assertThat(size).isZero();
    }

    @Test
    void givenList_whenSize_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("size()");

        //When
        final int size = testList.size();

        //Then
        assertThat(size).isOne();
    }

    @Test
    void givenEmptyList_whenClear_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        testList.clear();

        //Then
        assertThat(testList)
            .matches(list -> list.getFirst() == null)
            .matches(list -> list.getLast() == null)
            .matches(list -> list.size() == 0);
    }

    @Test
    void givenList_whenClear_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("clear()");

        //When
        testList.clear();

        //Then
        assertThat(testList)
            .matches(list -> list.getFirst() == null)
            .matches(list -> list.getLast() == null)
            .matches(list -> list.size() == 0);
    }

    @Test
    void givenEmptyList_whenToArray_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();

        //When
        Object[] result = testList.toArray();

        //When
        assertThat(result)
            .hasSize(0);
    }

    @Test
    void givenList_whenToArray_thenSuccess() {
        //Given
        final List<String> testList = new SinglyLinkedList<>();
        testList.addLast("new");
        testList.addLast("linked list");
        testList.addLast("to");
        testList.addLast("check");
        testList.addLast("toArray()");

        //When
        Object[] result = testList.toArray();

        //When
        assertThat(result)
            .hasSize(5);
    }

}