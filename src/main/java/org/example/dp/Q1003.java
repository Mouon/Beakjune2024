package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1003 {
    
    static int[][] fib =new int[41][2];
    static int[][] solve;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        solve = new int[count][2];
         fib[0][0]=1;
         fib[0][1]=0;
         fib[1][0]=0;
         fib[1][1]=1;

         for(int i=2; i<41; i++){
             fib[i][0]=fib[i-1][0]+fib[i-2][0];
             fib[i][1]=fib[i-1][1]+fib[i-2][1];
         }

        for(int i=0; i<count; i++){
            int num = Integer.parseInt(br.readLine());
            solve[i][0]=fib[num][0];
            solve[i][1]=fib[num][1];
        }

        for(int i=0; i<count; i++){
            System.out.println(solve[i][0]+" "+solve[i][1]);
        }



    }

}





/**
 *
 * 피보나치가 3이면
 * 0 -> 0
 * 1 -> 1
 * 2 -> 0->0, 1->1
 * 3 -> 2 -> 0->0, 1->1, 1 -> 1
 * */



/**
 *         dp[0][0]=1;
 *         dp[0][1]=0;
 *         dp[1][0]=0;
 *         dp[1][1]=1;
 *         for (int i = 2; i < 41; i++) {
 *             dp[i][0]=dp[i-1][0]+dp[i-2][0];
 *             dp[i][1]=dp[i-1][1]+dp[i-2][1];
 *         }
 *         for (int i = 0; i < count; i++) {
 *             int num=Integer.parseInt(br.readLine());
 *             System.out.println(dp[num][0]+" "+dp[num][1]);
 *         }
 * */