package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q2225 {

    static long dp[][];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");
        int N=Integer.parseInt(list[0]);
        int K=Integer.parseInt(list[1]);
        dp=new long[N+1][K+1];

        for(int n=0;n<=N;n++){
            dp[n][1]=1;
        }
        for(int k=1;k<=K;k++){
            dp[0][k]=1;
        }
        for(int n=1;n<=N;n++) {
            for(int k=2;k<=K;k++){
                dp[n][k]=(dp[n][k-1]+dp[n-1][k])%1000000000;
            }
        }

        System.out.println(dp[N][K]);

    }
}
