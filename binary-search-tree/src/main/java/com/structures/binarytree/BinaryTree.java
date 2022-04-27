package com.structures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }

    public boolean add(int value) {
        final Node newNode = new Node(value);

        return add(root, newNode);
    }

    private boolean add(Node rootNode, Node newNode) {
        if (rootNode.value > newNode.value) {
            if (Objects.isNull(rootNode.left)) {
                rootNode.left = newNode;
                return true;
            } else {
                add(rootNode.left, newNode);
                return true;
            }
        } else {
            if (Objects.isNull(rootNode.right)) {
                rootNode.right = newNode;
                return true;
            } else {
                add(rootNode.right, newNode);
            }
        }

        return false;
    }

    public boolean delete(int value) {
        if (root.value == value) {
            clear(root);
            root = null;
            return true;
        }

        return delete(null, root, value);
    }

    private boolean delete(Node parentNode, Node currentNode, int deletedValue) {
        if (currentNode == null) {
            return false;
        } else if (currentNode.value == deletedValue) {
            if (Objects.isNull(currentNode.left) && Objects.isNull(currentNode.right)) {
                if (parentNode.left.equals(currentNode)) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else if (Objects.isNull(currentNode.left)) {
                if (parentNode.left.equals(currentNode)) {
                    parentNode.left = currentNode.right;
                } else {
                    parentNode.right = currentNode.right;
                }
            } else if (Objects.isNull(currentNode.right)) {
                if (parentNode.left.equals(currentNode)) {
                    parentNode.left = currentNode.left;
                } else {
                    parentNode.right = currentNode.left;
                }
            } else {
                Node tmp = currentNode.left;
                if (parentNode.left.equals(currentNode)) {
                    parentNode.left = currentNode.right;
                } else {
                    parentNode.right = currentNode.right;
                }
                add(parentNode, tmp);
            }
            return true;
        } else if (currentNode.value > deletedValue) {
            return delete(currentNode, currentNode.left, deletedValue);
        } else {
            return delete(currentNode, currentNode.right, deletedValue);
        }
    }

    public void clear(Node node) {
        if (Objects.nonNull(node.left)) {
            clear(node.left);
            node.left = null;
        }
        if (Objects.nonNull(node.right)) {
            clear(node.right);
            node.right = null;
        }

        node.value = 0;
    }

    public Node search(int value) {
        return search(root, value);
    }


    private Node search(Node rootNode, int findValue) {
        if (rootNode == null) {
            return null;
        } else if (rootNode.value == findValue) {
            return rootNode;
        }

        if (rootNode.value > findValue) {
            return search(rootNode.left, findValue);
        } else {
            return search(rootNode.right, findValue);
        }
    }

    public void print() {
        final List<Integer> listWithTreeValues = new ArrayList<>();
        preOrderDepthFirstTraversal(listWithTreeValues, root);
        System.out.println(listWithTreeValues);

        listWithTreeValues.clear();
        inOrderDepthFirstTraversal(listWithTreeValues, root);
        System.out.println(listWithTreeValues);

        listWithTreeValues.clear();
        postOrderDepthFirstTraversal(listWithTreeValues, root);
        System.out.println(listWithTreeValues);

        listWithTreeValues.clear();
        breadthFirstTraversal(listWithTreeValues);
        System.out.println(listWithTreeValues);
    }

    public void preOrderDepthFirstTraversal(List<Integer> list, Node current) {
        if (Objects.isNull(current)) {
            return;
        }

        list.add(current.value);
        if (Objects.nonNull(current.left)) {
            preOrderDepthFirstTraversal(list, current.left);
        }
        if (Objects.nonNull(current.right)) {
            preOrderDepthFirstTraversal(list, current.right);
        }
    }

    public void inOrderDepthFirstTraversal(List<Integer> list, Node current) {
        if (Objects.isNull(current)) {
            return;
        }

        if (Objects.nonNull(current.left)) {
            inOrderDepthFirstTraversal(list, current.left);
        }
        list.add(current.value);
        if (Objects.nonNull(current.right)) {
            inOrderDepthFirstTraversal(list, current.right);
        }
    }

    public void postOrderDepthFirstTraversal(List<Integer> list, Node current) {
        if (Objects.isNull(current)) {
            return;
        }

        if (Objects.nonNull(current.left)) {
            postOrderDepthFirstTraversal(list, current.left);
        }
        if (Objects.nonNull(current.right)) {
            postOrderDepthFirstTraversal(list, current.right);
        }
        list.add(current.value);
    }

    public void breadthFirstTraversal(List<Integer> list) {
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.value);

            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
        }
    }

    class Node {

        int value;

        Node left;

        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

}
