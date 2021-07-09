package com.justtip.backend.exercises;

import java.util.Hashtable;

public class JustHashTable {

    public static void main(String[] args) {
        // add elements to hashtable
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>();

        // inserting the elements using put()
        ht1.put(1,"one");
        ht1.put(2,"two");
        ht1.put(3,"three");

        ht2.put(4,"four");
        ht2.put(5,"five");
        ht2.put(6,"six");

        System.out.println("Mappings of ht1 " + ht1);
        System.out.println("Mappings of ht2 " + ht2);
    }
}
