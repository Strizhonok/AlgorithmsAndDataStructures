package com.structures;

import com.structures.narytree.NAryTree;

public class App {

    public static void main(String[] args) {
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

        System.out.println(tree.getListWithValues());
    }

}
