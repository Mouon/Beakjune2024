package org.example.prefix_sum;

import java.util.Scanner;

public class Q2851 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i=0;i<10;i++){
            arr[i] = scan.nextInt();
        }

        int sum = 0;
        int dis = Integer.MAX_VALUE;

        for (int i=0;i<10;i++){
            sum += arr[i];
            if(Math.abs(sum-100)>dis){
                sum -= arr[i];
                break;
            }
            dis = Math.abs(sum-100);
        }

        System.out.print(sum);


    }
}
