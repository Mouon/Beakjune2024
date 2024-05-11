package org.example.dp;

import java.util.Scanner;

public class Q10844 {
    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        long result = 0;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        int[][] dp = new int[N+1][10];

        for(int i=1;i<10;i++){
            dp[1][i]=1;
        }


        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){

                if(j>0) {
                    dp[i][j] +=dp[i-1][j-1];
                    dp[i][j] %=MOD;
                }
                if(j<9) {
                    dp[i][j] +=dp[i-1][j+1];
                    dp[i][j] %=MOD;
                }

            }
        }

            for(int j=0;j<10;j++){
                result+=dp[N][j];
                result %=MOD;
            }

        System.out.println(result);
    }
}
