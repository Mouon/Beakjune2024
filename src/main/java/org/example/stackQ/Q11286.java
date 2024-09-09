package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                        else return Math.abs(o1) - Math.abs(o2);
                    }
                });

        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());

            if(input!=0){
                minQ.add(input);
            }else {
                if(!minQ.isEmpty()){
                    System.out.println(minQ.poll());
                }else {
                    System.out.println(0);
                }
            }
        }

    }
}
