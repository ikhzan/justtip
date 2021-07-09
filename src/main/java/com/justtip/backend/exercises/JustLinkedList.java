package com.justtip.backend.exercises;

import java.util.Iterator;
import java.util.LinkedList;

// data structure
public class JustLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linky = new LinkedList<Integer>();
//        linky.add("first");
//        linky.add("second");
        linky.add(1);
        linky.add(2);
        linky.add(78);
        System.out.println(linky);

        Iterator it = linky.iterator();
        while (it.hasNext()) if ((int) it.next() == 78) {
            System.out.println("We found 78");
        }

        Node nodeA = new Node(6);
        Node nodeB = new Node(3);
        Node nodeC = new Node(4);
        Node nodeD = new Node(2);

    }


}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
