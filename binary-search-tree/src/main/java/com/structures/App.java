package com.structures;

import com.structures.binarytree.BinaryTree;

public class App {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(100);
        tree.add(56);
        tree.add(120);
        tree.add(50);
        tree.add(80);
        tree.add(25);
        tree.add(52);
        tree.add(70);
        tree.add(92);
        tree.add(111);
        tree.add(145);
        tree.add(105);
        tree.add(118);
        tree.add(104);
        tree.add(106);
        tree.add(113);
        tree.add(119);
        tree.add(132);
        tree.add(121);
        tree.add(138);
        tree.add(152);
        tree.add(150);
        tree.add(155);

        tree.print();
        tree.reverseTree();
        tree.print();
    }

}
