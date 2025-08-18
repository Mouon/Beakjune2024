package org.example.dp;

import java.util.Scanner;

/** 어케하누?
 * 제곱수 어케 아누???
 * */
public class Q1699 {
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        int[] dp = new int[N+1];

        dp[1] = 1;
        if(N>=2){
            dp[2] = 2;
        }
        if(N>=3){
            dp[3] = 3;
        }
        if(N>=4){
            dp[4] = 1;
        }
        if(N>=5){
            dp[5] = 2;
        }

        if(N>=6){
            for(int i=6;i<=N;i++){
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }

        System.out.print(dp[N]);

    }

    /**
     * 재귀?
     *
     * */
}
