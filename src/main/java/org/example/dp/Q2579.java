package org.example.dp;

import java.io.IOException;
import java.util.Scanner;

public class Q2579 {
    static int stair[];
    static int dp[];
    static int N;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        stair = new int[N];
        dp = new int[N];

        for(int i=0;i<N;i++){
            stair[i] = scan.nextInt();
        }


        if (N == 1) {
            dp[0] = stair[0];
        } else if (N == 2) {
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
        } else {
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

            /** 도착점을 기준으로 생각하자 */
            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
            }
        }

        System.out.println(dp[N - 1]);

    }

}
