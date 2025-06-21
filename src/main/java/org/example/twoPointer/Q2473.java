package org.example.twoPointer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 세 포인터를 움직이는 방식은 너무 복잡하고 그렇다고 포문 세개를 돌려서 완전탐색하기에도 범위가 너무 크다.
 * 따라서 기준점 하나의 값을 지정하고 남은 두 용액을 투 포인터로 사용하는 방식이 가장 간단하다.
 * */
public class Q2473 {
    static int N;
    static int[] arr;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int p1=0, p2=0, p3=0;

        for(int i=0; i<N-2; i++){
            int left = i+1;
            int right = N-1;

            while (left<right){
                long sum = (long) arr[i] + arr[left] + arr[right];
                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    p1 = i;
                    p2 = left;
                    p3 = right;
                }
                if(sum==0){
                    p1 = i;
                    p2 = left;
                    p3 = right;
                    break;
                }else if(sum > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }

        System.out.println(arr[p1]+" "+arr[p2]+" "+arr[p3]);

    }


}
