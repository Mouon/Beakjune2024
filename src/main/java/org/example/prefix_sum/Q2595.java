package org.example.prefix_sum;

import java.util.Scanner;

// 아 슬라이딩이래..
public class Q2595 {
    public static void main(String[] args) {
        int n ,k;

        Scanner scan = new Scanner(System.in);

        n =  scan.nextInt();
        k = scan.nextInt();

        int[] arr = new int[n];


        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }

        int max = sum;

        for(int i=k;i<n;i++){
            sum = sum - arr[i-k] + arr[i];
            if(sum>max) max = sum;
        }

        System.out.print(max);

    }
}
