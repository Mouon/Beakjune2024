package org.example.implement;

import java.util.Scanner;

// 모르겠네 ㄹㅇ
// 복습간다
public class Q2343 {
    static int N, M;
    static int left, right;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        int sum = 0;

        arr = new int[N];


        for(int i=0;i<N;i++){
            arr[i] = scan.nextInt();
            sum += arr[i];
            left = Math.max(left, arr[i]);
        }
        right = sum;

        System.out.print(binSearch(left,right));

    }

    public static long binSearch(long left, long right) {

        while (left<=right){
            int sum =0;
            long mid = (left+right)/2;
            long count =1;

            for(int i=0;i<N;i++){
                sum += arr[i];
                if(sum>mid){
                    sum = arr[i];
                    count++;
                }
            }

            if(count <= M){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
