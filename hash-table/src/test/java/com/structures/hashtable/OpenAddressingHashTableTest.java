package com.structures.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class OpenAddressingHashTableTest {

    @Test
    void givenHashTable_whenAdd_thenSuccess() {
        //Given
        final OpenAddressingHashTable<Integer, String> testHashTable = new OpenAddressingHashTable<>();

        //When
        testHashTable.add(10, "test1");
        testHashTable.add(20, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 4)
            .matches(hashTable -> hashTable.get(10).equals("test1"))
            .matches(hashTable -> hashTable.get(20).equals("test2"))
            .matches(hashTable -> hashTable.get(30).equals("test3"))
            .matches(hashTable -> hashTable.get(40).equals("test4"));
    }

    @Test
    void givenHashTable_whenDelete_thenSuccess() {
        //Given
        final OpenAddressingHashTable<Integer, String> testHashTable = new OpenAddressingHashTable<>();
        testHashTable.add(10, "test1");
        testHashTable.add(20, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");

        //When
        testHashTable.delete(10);
        testHashTable.delete(30);

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 2)
            .matches(hashTable -> Objects.isNull(hashTable.get(10)))
            .matches(hashTable -> hashTable.get(20).equals("test2"))
            .matches(hashTable -> Objects.isNull(hashTable.get(30)))
            .matches(hashTable -> hashTable.get(40).equals("test4"));
    }

    @Test
    void givenHashTable_whenGet_thenSuccess() {
        //Given
        final OpenAddressingHashTable<Integer, String> testHashTable = new OpenAddressingHashTable<>();
        testHashTable.add(10, "test1");
        testHashTable.add(20, "test2");
        testHashTable.add(30, "test3");
        testHashTable.add(40, "test4");

        //When
        final String value10 = testHashTable.get(10);
        final String value30 = testHashTable.get(30);

        //Then
        assertThat(testHashTable)
            .isNotNull()
            .matches(hashTable -> hashTable.size() == 4)
            .matches(hashTable -> value10.equals("test1"))
            .matches(hashTable -> value30.equals("test3"));
    }

}