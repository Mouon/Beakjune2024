package org.example.stackQ;

public class MyStack<T> {

    private Object[] stack;
    private int top;
    private int capacity;

    public MyStack(int size){
        this.capacity = size;
        this.stack = new Object[capacity];
        this.top = -1;
    }

    public void push(T item){
        if(top == capacity -1){
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = item;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return (T) stack[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
