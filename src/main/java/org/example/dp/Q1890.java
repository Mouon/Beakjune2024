package org.example.dp;

import java.util.Scanner;

public class Q1890 {
    static int N;
    static long[][] board, dp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        board = new long[N][N];
        dp = new long[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = scan.nextInt();
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) continue;

                long go = board[i][j];

                if (j + go < N) dp[i][(int) (j + go)] += dp[i][j];
                if (i + go < N) dp[(int) (i + go)][j] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);

    }

}
