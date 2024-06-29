package org.example.dp;

import java.io.IOException;
import java.util.Scanner;

public class Q1932 {
    static int dp[][];
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        dp=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=scan.nextInt();
            }
        }


        for(int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]+=Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);

    }

}
