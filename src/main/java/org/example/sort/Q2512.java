package org.example.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q2512 {
    static int N, sum=0,M,mid=0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arr = new int[N];

        for (int i=0;i<N;i++){
            arr[i] = scan.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        M = scan.nextInt();

        binary();

        System.out.println(mid);

    }

    static void binary(){
        int min = 0;
        int max = arr[N-1];
        while (min<=max){
            int tempMid = (min + max) / 2;
            int currentSum = 0;
            for (int i=0;i<N;i++){
                currentSum += Math.min(arr[i], tempMid);
            }
            sum = currentSum;
            if(sum<=M){
                mid = tempMid;
                min = tempMid + 1;

            } else{
                max = tempMid - 1;
            }

        }
    }

}
