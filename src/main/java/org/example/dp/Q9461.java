package org.example.dp;

import java.util.Scanner;

public class Q9461 {
    static int T;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;


        for(int i=11;i<=100;i++){
            dp[i] = dp[i-5] + dp[i-1];
        }

        for(int i=0;i<T;i++){
            System.out.println(dp[scan.nextInt()]);
        }


    }
}


/**
 *  나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
 * 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 * 1 = 1
 * 1 = 1
 * 1 + 1 = 2
 * 2 = 2
 * 2 + 1 = 3
 * 3 + 1 = 4
 * 4 + 1 = 5
 * 5 + 2 = 7
 * 7 + 2 = 9
 */
