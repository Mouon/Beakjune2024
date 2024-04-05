package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1003 {
    
    static int[][] dp =new int[41][2];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for (int i = 2; i < 41; i++) {
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }
        for (int i = 0; i < count; i++) {
            int num=Integer.parseInt(br.readLine());
            System.out.println(dp[num][0]+" "+dp[num][1]);
        }


    }

}
