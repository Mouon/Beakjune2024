package org.example.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1644 {
    static int N, C=0, sum=0;
    static int[] num = new int[4000001];
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        for(int i=2;i<=N;i++){
            num[i] = i;
        }

        for(int i=2; i<=N; i++){
            if(num[i] == 0) continue;


            for(int j=2*i; j<=N; j+=i){
                if((long)(i)*j > Integer.MAX_VALUE) continue;
                num[j] = 0;
            }
        }


        for(int i=2;i<=N;i++){
            if(num[i] == 0) continue;
            prime.add(num[i]);
        }

        if(prime.isEmpty()) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = 0;

        if(prime.get(prime.size()-1)==N){
            C++;
        }
        while (start <= end && end < prime.size()){
            if(sum < N){
                sum += prime.get(end++);
            }else {
                if(sum == N){
                    C ++;
                }
                sum -= prime.get(start++);
            }
        }

        System.out.println(C);

    }
}
