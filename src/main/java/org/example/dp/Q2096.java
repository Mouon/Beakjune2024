package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q2096 {
    static int N;
    static int[][] board, dp,dp2;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N= scan.nextInt();

        board = new  int[N][3];
        dp = new  int[N][3];
        dp2 = new  int[N][3];

        for(int i=0;i<N;i++){
            board[i][0] = scan.nextInt();
            dp[i][0]= board[i][0];
            dp2[i][0] = board[i][0];

            board[i][1] = scan.nextInt();
            dp[i][1] = board[i][1];
            dp2[i][1] = board[i][1];

            board[i][2] = scan.nextInt();
            dp[i][2] = board[i][2];
            dp2[i][2] = board[i][2];
        }

        for(int i=1;i<N;i++){
            dp[i][0] += Math.max(dp[i-1][0],dp[i-1][1]);
            int flag = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] += Math.max(dp[i-1][2],flag);
            dp[i][2] += Math.max(dp[i-1][1],dp[i-1][2]);

            dp2[i][0] += Math.min(dp2[i-1][0],dp2[i-1][1]);
            int flag2 = Math.min(dp2[i-1][0],dp2[i-1][1]);
            dp2[i][1] += Math.min(dp2[i-1][2],flag2);
            dp2[i][2] += Math.min(dp2[i-1][1],dp2[i-1][2]);
        }

        Arrays.sort(dp[N-1]);
        Arrays.sort(dp2[N-1]);

        System.out.print(dp[N-1][2]+" "+dp2[N-1][0]);

    }
}
