package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Q9084 {

    public static void main(String[] args) {

        int[][] dp;


        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();

        int[] result = new int[count+1];

        for (int l = 0; l < count; l++) {
            int N = scan.nextInt();
            scan.nextLine();
            String str = scan.nextLine();
            int K = scan.nextInt();

            String[] list = str.split(" ");
            int[] coins = new int[N];

            for (int n = 0; n < N; n++) {
                coins[n] = Integer.parseInt(list[n]);
            }

            dp = new int[N][K+1];
            Arrays.sort(coins);

            for (int i = 0; i < N; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= K; i++) {
                if (i % coins[0] == 0) {
                    dp[0][i] = 1;
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j <= K; j++) {
                    if (j < coins[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                    }
                }
            }


            result[l]=dp[N - 1][K];

        }

        for (int l = 0; l < count; l++) {

            System.out.println(result[l]);

        }

        }

}
