package com.structures.binarytree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void givenTree_whenAdd_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);

        //When
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(25);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100).left.value == 56)
            .matches(tree -> tree.search(100).right.value == 120)
            .matches(tree -> tree.search(56).left.value == 50)
            .matches(tree -> tree.search(56).right.value == 80)
            .matches(tree -> tree.search(50).left.value == 25)
            .matches(tree -> tree.search(50).right == null)
            .matches(tree -> tree.search(120).left == null)
            .matches(tree -> tree.search(120).right == null);
    }

    @Test
    void givenTree_whenDeleteNodeWithoutChildren_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(25);

        //When
        testTree.delete(120);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100).left.value == 56)
            .matches(tree -> tree.search(100).right == null)
            .matches(tree -> tree.search(56).left.value == 50)
            .matches(tree -> tree.search(56).right.value == 80)
            .matches(tree -> tree.search(50).left.value == 25)
            .matches(tree -> tree.search(50).right == null);
    }

    @Test
    void givenTree_whenDeleteNodeWithRightChildren_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(130);

        //When
        testTree.delete(120);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100).left.value == 56)
            .matches(tree -> tree.search(100).right.value == 130)
            .matches(tree -> tree.search(56).left.value == 50)
            .matches(tree -> tree.search(56).right.value == 80)
            .matches(tree -> tree.search(50).left == null)
            .matches(tree -> tree.search(50).right == null)
            .matches(tree -> tree.search(80).left == null)
            .matches(tree -> tree.search(80).right == null)
            .matches(tree -> tree.search(130).left == null)
            .matches(tree -> tree.search(130).right == null);
    }

    @Test
    void givenTree_whenDeleteNodeWithLeftChildren_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);

        //When
        testTree.delete(120);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100).left.value == 56)
            .matches(tree -> tree.search(100).right.value == 110)
            .matches(tree -> tree.search(56).left.value == 50)
            .matches(tree -> tree.search(56).right.value == 80)
            .matches(tree -> tree.search(50).left == null)
            .matches(tree -> tree.search(50).right == null)
            .matches(tree -> tree.search(80).left == null)
            .matches(tree -> tree.search(80).right == null)
            .matches(tree -> tree.search(110).left == null)
            .matches(tree -> tree.search(110).right == null);
    }

    @Test
    void givenTree_whenDeleteNodeWithBothChildren_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);
        testTree.add(130);
        testTree.add(105);
        testTree.add(115);
        testTree.add(125);
        testTree.add(135);

        //When
        testTree.delete(120);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100).left.value == 56)
            .matches(tree -> tree.search(100).right.value == 130)
            .matches(tree -> tree.search(56).left.value == 50)
            .matches(tree -> tree.search(56).right.value == 80)
            .matches(tree -> tree.search(50).left == null)
            .matches(tree -> tree.search(50).right == null)
            .matches(tree -> tree.search(80).left == null)
            .matches(tree -> tree.search(80).right == null)
            .matches(tree -> tree.search(130).left.value == 125)
            .matches(tree -> tree.search(130).right.value == 135)
            .matches(tree -> tree.search(135).left == null)
            .matches(tree -> tree.search(135).right == null)
            .matches(tree -> tree.search(125).left.value == 110)
            .matches(tree -> tree.search(125).right == null)
            .matches(tree -> tree.search(110).left.value == 105)
            .matches(tree -> tree.search(110).right.value == 115)
            .matches(tree -> tree.search(105).left == null)
            .matches(tree -> tree.search(105).right == null)
            .matches(tree -> tree.search(115).left == null)
            .matches(tree -> tree.search(115).right == null);
    }

    @Test
    void givenTree_whenDeleteRoot_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);

        //When
        testTree.delete(100);

        //Then
        assertThat(testTree)
            .isNotNull()
            .matches(tree -> tree.search(100) == null)
            .matches(tree -> tree.search(56) == null)
            .matches(tree -> tree.search(120) == null)
            .matches(tree -> tree.search(50) == null)
            .matches(tree -> tree.search(80) == null);

    }

    @Test
    void givenTree_whenPreOrderDepthFirstTraversal_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);
        testTree.add(130);
        testTree.add(105);
        testTree.add(115);
        testTree.add(125);
        testTree.add(135);

        //When
        final List<Integer> resultList = new ArrayList<>();
        testTree.preOrderDepthFirstTraversal(resultList, testTree.search(100));

        //Then
        final List<Integer> expectedList = List.of(100, 56, 50, 80, 120, 110, 105, 115, 130, 125, 135);

        assertThat(resultList)
            .isNotNull()
            .containsExactlyElementsOf(expectedList);
    }

    @Test
    void givenTree_whenInOrderDepthFirstTraversal_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);
        testTree.add(130);
        testTree.add(105);
        testTree.add(115);
        testTree.add(125);
        testTree.add(135);

        //When
        final List<Integer> resultList = new ArrayList<>();
        testTree.inOrderDepthFirstTraversal(resultList, testTree.search(100));

        //Then
        final List<Integer> expectedList = List.of(50, 56, 80, 100, 105, 110, 115, 120, 125, 130, 135);

        assertThat(resultList)
            .isNotNull()
            .containsExactlyElementsOf(expectedList);
    }

    @Test
    void givenTree_whenPostOrderDepthFirstTraversal_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);
        testTree.add(130);
        testTree.add(105);
        testTree.add(115);
        testTree.add(125);
        testTree.add(135);

        //When
        final List<Integer> resultList = new ArrayList<>();
        testTree.postOrderDepthFirstTraversal(resultList, testTree.search(100));

        //Then
        final List<Integer> expectedList = List.of(50, 80, 56, 105, 115, 110, 125, 135, 130, 120, 100);

        assertThat(resultList)
            .isNotNull()
            .containsExactlyElementsOf(expectedList);
    }

    @Test
    void givenTree_whenBreadthFirstTraversal_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(110);
        testTree.add(130);
        testTree.add(105);
        testTree.add(115);
        testTree.add(125);
        testTree.add(135);

        //When
        final List<Integer> resultList = new ArrayList<>();
        testTree.breadthFirstTraversal(resultList);

        //Then
        final List<Integer> expectedList = List.of(100, 56, 120, 50,80, 110, 130, 105, 115, 125, 135);

        assertThat(resultList)
            .isNotNull()
            .containsExactlyElementsOf(expectedList);
    }

    @Test
    void givenTree_whenReverseTree_thenSuccess() {
        //Given
        BinaryTree testTree = new BinaryTree(100);
        testTree.add(56);
        testTree.add(120);
        testTree.add(50);
        testTree.add(80);
        testTree.add(25);
        testTree.add(111);
        testTree.add(145);

        //When
        testTree.reverseTree();

        //Then
        final List<Integer> resultList = new ArrayList<>();
        testTree.breadthFirstTraversal(resultList);

        final List<Integer> expectedList = List.of(100, 120, 56, 145, 111, 80, 50, 25);

        assertThat(resultList)
            .isNotNull()
            .containsExactlyElementsOf(expectedList);
    }

}