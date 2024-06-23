package org.example.dp;

import java.io.IOException;
import java.util.Scanner;

public class Q1149 {

    static int M;
    static int[][] RGB;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        scan.nextLine();
        RGB = new int[M][3];
        dp = new int[M][3];

        for (int i = 0; i < M; i++) {
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(arr[j]);

            }
        }

        dp[0][0]=RGB[0][0];
        dp[0][1]=RGB[0][1];
        dp[0][2]=RGB[0][2];

        for (int i = 1; i < M; i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+RGB[i][0];
            dp[i][1]=Math.min(dp[i-1][2],dp[i-1][0])+RGB[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+RGB[i][2];
        }


        System.out.println(Math.min(dp[M-1][2],Math.min(dp[M-1][0],dp[M-1][1])));


    }
}
