package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp=new long[31];

        dp[0]=1;
        dp[2]=3;
        dp[4]=11;

        for(int i=6;i<31;i+=2){
            dp[i] = dp[i - 2]*3;
            for(int j=0;j<i-2;j+=2){
                dp[i]+=dp[j]*2;
            }
        }

        System.out.print(dp[n]);

    }

    /**
     * 3*6=41
     * */
}

