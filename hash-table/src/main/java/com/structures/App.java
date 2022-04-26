package com.structures;

import com.structures.hashtable.ChainedHashTable;
import com.structures.hashtable.OpenAddressingHashTable;

public class App {

    public static void main(String[] args) {
        final OpenAddressingHashTable<Integer, String> openAddressingHashTable = new OpenAddressingHashTable<>();
        openAddressingHashTable.add(10, "test1");
        openAddressingHashTable.add(20, "test2");
        openAddressingHashTable.add(30, "test3");
        openAddressingHashTable.add(40, "test4");
        openAddressingHashTable.add(15, "test5");
        openAddressingHashTable.add(25, "test6");
        openAddressingHashTable.add(35, "test7");
        openAddressingHashTable.add(40, "test8");

        final ChainedHashTable<Integer, String> chainedHashTable = new ChainedHashTable<>();
        chainedHashTable.add(1, "test1");
        chainedHashTable.add(2, "test2");
        chainedHashTable.add(3, "test3");
        chainedHashTable.add(4, "test4");
        chainedHashTable.add(1, "test5");
        chainedHashTable.add(2, "test6");
        chainedHashTable.add(3, "test7");
        chainedHashTable.add(4, "test8");
    }

}
