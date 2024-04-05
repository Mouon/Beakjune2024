package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        int[] dp=new int[11];
        Arrays.fill(dp,0);
        int[] list=new int[count+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 3; i< dp.length; i++) {
            if(dp[i]==0) {
                dp[i] += dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        for (int i=0;i<count;i++) {
            list[i]=Integer.parseInt(br.readLine());
        }
        for (int i=0;i<count;i++) {
            System.out.println(dp[list[i]]);
        }

    }
}
