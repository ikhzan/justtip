package com.justtip.backend.exercises;

public class DynamicStack {

    public static void main(String[] args) {
        DynamicStack nums = new DynamicStack();

        nums.push(15);
        nums.show();
        nums.push(8);
        nums.show();
        nums.push(10);
        nums.show();
        nums.push(10);
        nums.show();
        nums.push(10);
        nums.show();

        nums.pop();
        nums.show();
        nums.pop();
        nums.show();
        nums.pop();
        nums.show();
    }

    int capacity = 2;
    int[] stack = new int[capacity];
    int top = 0;

    // to add
    public void push(int data){
        // check if stack is full
        if (size() == capacity){
            expand();
        }
        stack[top] = data;
        top++;

    }

    private void expand() {
        int length = size();
        int[] newStack = new int[capacity*2];
        // copy stack to newstack
        System.arraycopy(stack,0,newStack,0,length);
        stack = newStack;
        // increase capacity
        capacity *= 2;
    }

    // print results
    public void show(){
        for(int n : stack){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // to remove data from collection
    // last in first out
    public int pop(){
        int data = 0;
        if (isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            top--;
            data = stack[top];
            stack[top] = 0;
            shrink();
        }

        return data;
    }

    private void shrink() {
        // reduce capacity
        int length = size();
        if (length <= (capacity/2)/2)
            capacity = capacity/2;


        int[] newStack = new int[capacity];
        System.arraycopy(stack,0,newStack,0,length);
        stack = newStack;

    }

    // to find data
    public int peek(){
        int data;
        data = stack[top-1];
        return data;
    }

    public boolean isEmpty(){
        return top <= 0;
    }

    public int size(){
        return top;
    }
}
