package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());

            if(input>0){
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
