package org.example.math;

import java.util.Scanner;

public class Q19951 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=scan.nextInt();
        }

        int[] delta = new int[N+2];

        for(int i=0;i<M;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int amount = scan.nextInt();

            delta[start] += amount;
            delta[end+1] -= amount;
        }

        int add = 0;
        for(int i=1;i<=N;i++){
             add += delta[i];
             arr[i]+=add;
        }

        for(int i=1;i<=N;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
