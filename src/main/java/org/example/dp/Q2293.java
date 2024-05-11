package org.example.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q2293 {
    static int dp[][];
    static long count=0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");
        int N=Integer.parseInt(list[0]);
        int K=Integer.parseInt(list[1]);
        dp =new int[N][K+1];
        int[] coins =new int[N];
        for(int n=0; n<N; n++){
            coins[n]=scan.nextInt();
        }

        Arrays.sort(coins);


        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= K; i++) {
            if (i % coins[0] == 0) {dp[0][i] = 1;}
        }

        for (int i=1;i<N;i++){
            for(int j=0;j<=K;j++) {
                if(j<coins[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }


        System.out.println(dp[N-1][K]);

    }

}
