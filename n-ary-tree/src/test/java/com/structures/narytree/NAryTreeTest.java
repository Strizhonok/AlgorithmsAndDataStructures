package com.structures.narytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NAryTreeTest {

    @Test
    void givenTree_whenAdd_thenSuccess() {
        //Given
        final NAryTree testTree = new NAryTree(100);

        //When
        testTree.add(testTree.getRoot(), 3);
        testTree.add(testTree.getRoot(), 4);

        testTree.add(testTree.get(3), 7);
        testTree.add(testTree.get(3), 8);
        testTree.add(testTree.get(3), 9);

        testTree.add(testTree.get(4), 10);
        testTree.add(testTree.get(4), 11);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.get(100).children.size() == 2)
            .matches(tree -> tree.get(3).children.size() == 3)
            .matches(tree -> tree.get(4).children.size() == 2);
    }

    @Test
    void givenTree_whenDelete_thenSuccess() {
        //Given
        NAryTree testTree = new NAryTree(100);
        testTree.add(testTree.getRoot(), 3);
        testTree.add(testTree.getRoot(), 4);
        testTree.add(testTree.getRoot(), 5);
        testTree.add(testTree.getRoot(), 6);

        testTree.add(testTree.get(3), 7);
        testTree.add(testTree.get(3), 8);
        testTree.add(testTree.get(3), 9);

        testTree.add(testTree.get(4), 10);
        testTree.add(testTree.get(4), 11);

        testTree.add(testTree.get(5), 12);
        testTree.add(testTree.get(5), 13);
        testTree.add(testTree.get(5), 14);
        testTree.add(testTree.get(5), 15);
        testTree.add(testTree.get(5), 16);

        testTree.add(testTree.get(6), 17);

        testTree.add(testTree.get(7), 18);

        testTree.add(testTree.get(8), 19);
        testTree.add(testTree.get(8), 20);

        //When
        testTree.delete(testTree.getRoot(), 3);
        final List<Integer> resultList = testTree.getListWithValues();

        //Then
        final List<Integer> expectedList = List
            .of(100, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        assertThat(resultList)
            .isNotNull()
            .isNotEmpty()
            .containsExactlyElementsOf(expectedList);
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.get(100).children.size() == 6)
            .matches(tree -> tree.get(5).children.size() == 5)
            .matches(tree -> tree.get(4).children.size() == 2);
    }

    @Test
    void givenTree_whenGetListWithValues_thenSuccess() {
        //Given
        NAryTree tree = new NAryTree(100);
        tree.add(tree.getRoot(), 3);
        tree.add(tree.getRoot(), 4);
        tree.add(tree.getRoot(), 5);
        tree.add(tree.getRoot(), 6);

        tree.add(tree.get(3), 7);
        tree.add(tree.get(3), 8);
        tree.add(tree.get(3), 9);

        tree.add(tree.get(4), 10);
        tree.add(tree.get(4), 11);

        tree.add(tree.get(5), 12);
        tree.add(tree.get(5), 13);
        tree.add(tree.get(5), 14);
        tree.add(tree.get(5), 15);
        tree.add(tree.get(5), 16);

        tree.add(tree.get(6), 17);

        tree.add(tree.get(7), 18);

        tree.add(tree.get(8), 19);
        tree.add(tree.get(8), 20);

        //When
        final List<Integer> resultList = tree.getListWithValues();

        //Then
        final List<Integer> expectedList = List
            .of(100, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        assertThat(resultList)
            .isNotNull()
            .isNotEmpty()
            .containsExactlyElementsOf(expectedList);
    }

}