package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Q2294 {
    static int dp[][];
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");
        int N=Integer.parseInt(list[0]);
        int K=Integer.parseInt(list[1]);

        dp =new int[N][K+1];
        int[] coins =new int[N];

        for(int n=0; n<N; n++){
            coins[n] = Integer.parseInt(scan.next());
        }

        Arrays.sort(coins);

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 10001);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= K; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i/coins[0];
            }
        }
        for (int i=1;i<N;i++){
            for(int j=2;j<=K;j++) {
                if(j<coins[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
                    }
                }
            }


        if (dp[N - 1][K] == 10001)
            System.out.println(-1);
        else
            System.out.println(dp[N - 1][K]);
    }

}
