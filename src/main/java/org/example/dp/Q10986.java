package org.example.dp;

import java.util.Scanner;

//하나 배워간다 적합 % M이 같은 시점끼리 쌍을 지으면, 그 사이 구간의 합도 M으로 나눠떨어진다!
public class Q10986 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        long sum = 0;
        long result = 0;
        long[] count = new long[M];

        for(int i=0;i<N;i++){
            int num = scan.nextInt();
            sum+=num;
            int remainder = (int) (sum%M);

            if(remainder==0){
                result++;
            }

            result+=count[remainder];

            count[remainder]++;
        }

        System.out.println(result);

    }
}
