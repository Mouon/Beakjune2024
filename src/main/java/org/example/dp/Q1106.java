package org.example.dp;

import java.io.IOException;
import java.util.Scanner;

public class Q1106 {
    static int dp[][];
    static int[][] city ;

    static int N;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");
        int C=Integer.parseInt(list[0]);
        N=Integer.parseInt(list[1]);
        dp=new int[C+1][];
        city = new int[N+1][2];
        for(int i=0;i<N;i++){
            String cityInfo = scan.nextLine();
            String[] cityValue = cityInfo.split(" ");
            city[i][0]=Integer.parseInt(cityValue[0]);
            city[i][1]=Integer.parseInt(cityValue[1]);
        }

        System.out.println(dp[C]);

    }

    static int recur(int remainingCustomers, int currentCity) {

        if (remainingCustomers <= 0) return 0;
        if (currentCity == N) return Integer.MAX_VALUE;
        if (dp[currentCity][remainingCustomers] != 0) return dp[currentCity][remainingCustomers];

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= remainingCustomers / city[currentCity][1]; i++) {
            int remainingCustomersAfterInvestment = remainingCustomers - (i * city[currentCity][1]);
            int cost = i * city[currentCity][0] + recur(remainingCustomersAfterInvestment, currentCity + 1);
            minCost = Math.min(minCost, cost);
        }

        dp[currentCity][remainingCustomers] = minCost; // 결과를 저장
        return minCost;
    }

}
