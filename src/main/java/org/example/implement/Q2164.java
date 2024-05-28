package org.example.implement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Q2164 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<N;i++){
            deque.add(i+1);
        }

        while (true){

            int temp;
            if(deque.size()==1){
                break;
            }
            deque.removeFirst();
            temp=deque.removeFirst();
            deque.addLast(temp);

        }

        System.out.println(deque.peekLast());


    }
}
