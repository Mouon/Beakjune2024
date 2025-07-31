package org.example.dp;

import java.util.Scanner;

public class Q2747 {
    static int N;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int[] dp = new int[N+1];

        dp[0] = 0;

        if(N>0){
            dp[1] =1;
        }

        if(N>1){
            dp[2] =1;
            for(int i=3;i<=N;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
        }

        System.out.println(dp[N]);


    }
}
