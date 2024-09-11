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

        PriorityQueue<Integer> pq =new PriorityQueue<>((o1,o2)-> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if(num1==num2){
                return o1>o2 ? 1:-1;
            }
            return num1-num2;//return num1<num2 ? -1:1; 음수가 우선순위
        });

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input!=0){
                pq.offer(input);
            } else {
                if(!pq.isEmpty()){
                 System.out.println(pq.poll());
                }else {
                    System.out.println("0");
                }
            }
        }
    }
}
