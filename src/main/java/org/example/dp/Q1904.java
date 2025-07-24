package org.example.dp;

import java.util.Scanner;

// 시간 제한이 에바임 0.75초..
// 00,1
//
public class Q1904 {
    static int N;
    static int[] dp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        dp = new int[N+2];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }

        System.out.println(dp[N]);

    }
}
