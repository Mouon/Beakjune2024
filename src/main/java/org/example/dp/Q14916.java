package org.example.dp;

import java.util.Scanner;

public class Q14916 {
    static int[] dp;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        dp = new int[N+1];

        if (N >= 2){
            dp[2] = 1;
        }

        if(N >=4){
            dp[4] = 2;
        }

        if (N >= 5) {
            dp[5] = 1;
        }

        for(int i=6;i<N+1;i++){
            if(i%5==0){
                dp[i] = dp[i-5]+1;
            }else if(i% 2 == 0){
                dp[i] = dp[i-2]+1;
            }else {
                dp[i] = Math.min(dp[i-5],dp[i-2])+1;
            }
        }

        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}
