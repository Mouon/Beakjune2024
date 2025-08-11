package org.example.dp;

import java.util.Scanner;

public class Q11052 {
    static int N;
    static int[] cards, dp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        cards = new int[N+1];
        dp = new int[N+1];

        for(int i=1;i<=N;i++){
            cards[i] = scan.nextInt();
        }

        /**
         * 점화식 뭐 잘짜면 될듯
         * */
        if(N==1){
            System.out.println(dp[1]);
            return;
        }

        dp[1] = cards[1];

        for(int i=2;i<=N;i++){
            for(int j=1;j<=i-1;j++){
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            }
            dp[i] = Math.max(cards[i], dp[i]);
        }

        System.out.println(dp[N]);

    }
}
