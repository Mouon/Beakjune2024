package org.example.dp;

import java.util.Scanner;

public class Q2193 {
    static int N, count = 0;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        long[] dp = new long[N+1];

        dp[0] = 0;// 없음
        dp[1] = 1;// 1

        // 2 = 1
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2]; // 3 = 1(1) + 2(1)
        }

        System.out.println(dp[N]);

    }
}
