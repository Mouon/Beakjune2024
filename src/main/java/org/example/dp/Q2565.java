package org.example.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 블로그봄..
public class Q2565 {
    static int N;
    static int[][] line;
    static Integer[] dp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        line = new int[N][2];
        dp = new Integer[N];

        for(int i=0;i<N;i++){
            line[i][0] = scan.nextInt();
            line[i][1] = scan.nextInt();
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for(int i = 0; i < N; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(N - max);


    }

    static int recur(int N){
        if(dp[N] == null){
            dp[N] = 1;

            for(int i=N+1; i<dp.length;i++){

                if(line[N][1] < line[i][1]){
                    dp[N] = Math.max(dp[N], recur(i)+1);
                }
            }
        }
        return dp[N];
    }
}
