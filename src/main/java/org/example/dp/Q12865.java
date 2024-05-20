package org.example.dp;

import java.util.HashMap;
import java.util.Scanner;

public class Q12865 {
    static Integer[][] dp;
    static int[] W;
    static int[] V;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int result = 0;
        String str = scan.nextLine();
        String[] NK = str.split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            String input = scan.nextLine();
            String[] WV = input.split(" ");
            W[i] = Integer.parseInt(WV[0]);
            V[i] = Integer.parseInt(WV[1]);
        }

        System.out.println(DP(N-1, K));

    }

    /** 거꾸로 탐색 */
    static int DP(int i, int k) {


        if(i<0){
            return 0;
        }

        if(dp[i][k]==null){
            if(W[i]>k){
                dp[i][k]=DP(i-1,k);
            }
            if(W[i]<=k){
                dp[i][k]=Math.max(DP(i-1,k),DP(i-1,k-W[i])+V[i]);/** 이전 탐색과 현재 탐색 비교하기 -> 현재 탐색중인 무게를 최대무게에서 빼서 그 뺀만큼 (채웠을때 최댓값=,DP(i-1,k-W[i])+V[i]) 비교  */
            }
        }
        return dp[i][k];

    }
}
