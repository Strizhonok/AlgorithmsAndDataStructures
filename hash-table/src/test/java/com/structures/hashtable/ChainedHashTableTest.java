package com.structures.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class ChainedHashTableTest {

    @Test
    void givenHashTable_whenAdd_thenSuccess() {
        //Given
        final ChainedHashTable<Integer, String> testHashTable = new ChainedHashTable<>();

        //When
        testHashTable.add(10, "test1");
        testHashTable.add(25, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");
        testHashTable.add(50, "test5");

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 5)
            .matches(hashTable -> hashTable.get(10).equals("test1"))
            .matches(hashTable -> hashTable.get(25).equals("test2"))
            .matches(hashTable -> hashTable.get(30).equals("test3"))
            .matches(hashTable -> hashTable.get(40).equals("test4"))
            .matches(hashTable -> hashTable.get(50).equals("test5"));
    }

    @Test
    void givenHashTable_whenDelete_thenSuccess() {
        //Given
        final ChainedHashTable<Integer, String> testHashTable = new ChainedHashTable<>();
        testHashTable.add(10, "test1");
        testHashTable.add(25, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");
        testHashTable.add(50, "test5");

        //When
        testHashTable.delete(25);
        testHashTable.delete(30);

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 3)
            .matches(hashTable -> Objects.isNull(hashTable.get(25)))
            .matches(hashTable -> hashTable.get(10).equals("test1"))
            .matches(hashTable -> Objects.isNull(hashTable.get(30)))
            .matches(hashTable -> hashTable.get(40).equals("test4"))
            .matches(hashTable -> hashTable.get(50).equals("test5"));
    }

    @Test
    void givenHashTable_whenGet_thenSuccess() {
        //Given
        final ChainedHashTable<Integer, String> testHashTable = new ChainedHashTable<>();
        testHashTable.add(10, "test1");
        testHashTable.add(25, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");
        testHashTable.add(50, "test5");
        testHashTable.add(50, "test6");

        //When
        final String value25 = testHashTable.get(25);
        final String value50 = testHashTable.get(50);

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 5)
            .matches(hashTable -> value25.equals("test2"))
            .matches(hashTable -> value50.equals("test5"));
    }

}