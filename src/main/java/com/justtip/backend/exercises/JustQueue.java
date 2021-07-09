package com.justtip.backend.exercises;

public class JustQueue {

    int[] queue = new int[5];
    int size;
    int front;
    int rear;

    public static void main(String[] args) {
        JustQueue myqueue = new JustQueue();
        myqueue.enQueue(5);
        myqueue.enQueue(2);
        myqueue.enQueue(7);
        myqueue.enQueue(3);

        myqueue.deQueue();
        myqueue.deQueue();

        myqueue.enQueue(6);
        myqueue.enQueue(9);

        myqueue.deQueue();
        myqueue.deQueue();
//        myqueue.deQueue();
//        myqueue.deQueue();

        myqueue.show();
    }

    public void enQueue(int data){
        queue[rear] = data;
        rear = (rear + 1) % 5;
        size++;
    }

    public int deQueue(){
        int data = queue[front];
        // move front to forward
        // reduce size or length of list
        front= (front + 1) % 5;
        size--;
        return data;
    }

    public void show(){
        System.out.print("Elements: ");
        for (int i=0; i<size; i++){
            System.out.print(queue[(front+i) % 5] + " ");
        }
        System.out.println();
        for(int n : queue){
            System.out.print(n + " ");
        }
    }
}
