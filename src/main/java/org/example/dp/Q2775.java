package org.example.dp;

import java.util.Scanner;

public class Q2775 {
    static int[][] dp;
    static int k,n,T;
    public static void main(String[] args) {
        dp = new int[15][15];
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();

        for (int i=1;i<=14;i++){
            dp[1][i] = i + dp[1][i-1];
        }

        for (int i=2;i<=14;i++){
            for (int j=1;j<=14;j++){
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }

        for(int i=0;i<T;i++){
            n = scan.nextInt();
            k = scan.nextInt();
            System.out.println(dp[n][k]);
        }


    }
}
