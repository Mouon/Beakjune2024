package org.example.twoPointer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1940 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int arr[] = new int[N];
        int start = 0;
        int end = N-1;
        int count=0;
        for(int i=0;i<N;i++){
            arr[i]= scan.nextInt();
        }

        Arrays.sort(arr);

        while (start<end){
            int sum = arr[start] + arr[end];

            if(sum==M){
                count++;
                start++;
                end--;
            } else if (sum>M) {
                end--;
            } else if (sum<M) {
                start++;
            }
        }

        System.out.println(count);

    }
}
