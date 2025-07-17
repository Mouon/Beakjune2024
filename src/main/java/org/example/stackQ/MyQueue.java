package org.example.stackQ;

public class MyQueue<T> {

    private Object[] queue;
    private int front, rear, size, capacity;

    public MyQueue(int capacity){
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T item){
        if(size == capacity){
            throw new RuntimeException("Queue is full");
        }
        rear = (rear +1) % capacity; // 돌리기
        queue[rear] = item;
        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T item = (T) queue[front];
        front = (front + 1) % capacity;
        size --;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
