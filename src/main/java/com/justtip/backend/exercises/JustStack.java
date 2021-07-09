package com.justtip.backend.exercises;

public class JustStack {

    public static void main(String[] args) {
        JustStack nums = new JustStack();
        nums.push(15);
        nums.push(10);
        nums.push(11);
        nums.push(7);
        nums.show();
        nums.pop();
        nums.pop();
        nums.pop();
    }

    int stack[] = new int[5];
    int top = 0;

    // to add
    public void push(int data){
        // check if stack is full
        if (top == 5){
            System.out.println("Stack is full");
        }else{
            stack[top] = data;
            top++;
        }

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
        }

        return data;
    }

    // to find data or search
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
