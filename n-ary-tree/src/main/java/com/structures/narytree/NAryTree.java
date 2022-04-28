package com.structures.narytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class NAryTree {

    private final Node root;

    public NAryTree(int rootValue) {
        this.root = new Node(rootValue);
    }

    public void add(Node node, int value) {
        node.children.add(new Node(value));
    }

    public Node get(int value) {
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                if (Objects.isNull(node)) {
                    break;
                }
                if (node.value == value) {
                    return node;
                }

                queue.addAll(node.children);
            }
        }

        return null;
    }

    public boolean delete(Node parentNode, int deletedValue) {
        if (Objects.isNull(parentNode)) {
            return false;
        }

        final Node deletedNode = parentNode.children.stream()
            .filter(node -> node.value == deletedValue)
            .findFirst()
            .orElse(null);
        if (deletedNode == null) {
            return false;
        }

        parentNode.children.remove(deletedNode);
        parentNode.children.addAll(deletedNode.children);
        deletedNode.children = null;

        return true;
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> getListWithValues() {
        if (root == null) {
            return Collections.emptyList();
        }

        final List<Integer> values = new ArrayList<>();
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                if (Objects.isNull(node)) {
                    break;
                }
                values.add(node.value);

                queue.addAll(node.children);
            }
        }

        return values;
    }

    class Node {

        int value;

        List<Node> children = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }
}
