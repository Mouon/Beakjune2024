package org.example.listNArray;

import java.util.*;

public class Q1158 {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        for(int i=0; i<N; i++){
            queue.add(i+1);
        }

        while (!queue.isEmpty()){

            for(int i=0;i<K-1;i++){
                queue.add(queue.poll());
            }
            arr.add(queue.poll());

        }

        System.out.print("<");
        for (int n = 0; n < arr.size()-1; n++){
            System.out.print(arr.get(n)+", ");
        }
        System.out.print(arr.get(arr.size()-1)+">");


    }
}
