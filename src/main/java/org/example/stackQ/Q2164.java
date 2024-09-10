package org.example.stackQ;

import java.util.*;

public class Q2164 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=1;i<=N;i++){
            queue.add(i);
        }

        while (queue.size()!=1){
            queue.remove();
            int temp = queue.remove();
            queue.add(temp);
        }

        System.out.println(queue.remove());

    }
}
