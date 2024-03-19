package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1463 {
    static int dp[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        dp = new int[num+1];
        Arrays.fill(dp,-1);
        System.out.println(recur(num));

    }

    static int recur(int num) {
        if (num == 1) {
            return 0;
        }
        if (dp[num] != -1) {
            return dp[num];
        }
        dp[num] = Integer.MAX_VALUE;
        if (num % 3 == 0) {
            dp[num]= Math.min(dp[num], recur(num / 3) + 1);
        }
        if (num % 2 == 0) {
            dp[num] = Math.min(dp[num], recur(num / 2) + 1);
        }
        dp[num]= Math.min(dp[num], recur(num - 1) + 1);
        return dp[num];
    }
}
