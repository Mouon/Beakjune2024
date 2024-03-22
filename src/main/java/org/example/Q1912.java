package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1912 {
    static Long[] dp;
    static String[] arr;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        dp = new Long[count];
        String list = br.readLine();
        arr = list.split(" ");
        dp[0]=Long.parseLong(arr[0]);
        sum=dp[0];
        recur(count-1);
        System.out.println(sum);
    }
    static long recur(int N) {

        if(dp[N]==null){
            dp[N]=Math.max(recur(N-1)+Long.parseLong(arr[N]),Long.parseLong(arr[N]));
            sum=Math.max(dp[N],sum);
        }

        return dp[N];
    }


}
