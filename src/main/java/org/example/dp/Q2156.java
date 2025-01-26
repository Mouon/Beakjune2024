package org.example.dp;

import java.util.Scanner;
/**
 * DP의 뼈를 찌르는 문제 꼭 다시본다면 다시 풀어보기!
 * */
public class Q2156 {
    static int[] dp;
    static int[] wines;
    static int n;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        wines = new int[n+1];
        dp = new int[n+1];

        for(int i=1;i<n+1;i++){
            wines[i] = scan.nextInt();
        }

        dp[1] = wines[1];

        if(n > 1) {
            dp[2] = wines[1] + wines[2];
        }

        for(int i=3;i<n+1;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2],dp[i-3]+wines[i-1])+wines[i]);
        }

        System.out.println(dp[n]);

    }

}
