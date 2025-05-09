package org.example.dp;

import java.util.*;

public class ProGoingSchool {

    class Solution {
        static int num = 1000000007;

        public int solution(int m, int n, int[][] puddles) {

            int[][] dp = new int[n][m];

            for(int i=0;i<puddles.length;i++){
                dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
            }

            dp[0][0] = 1;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(dp[i][j] == -1) continue;

                    if(i-1>=0 && dp[i-1][j] != -1){
                        dp[i][j] += dp[i-1][j];
                    }

                    if(j-1>=0 && dp[i][j-1] != -1){
                        dp[i][j] += dp[i][j-1];
                    }
                    dp[i][j] %= num;
                }
            }

            int answer = dp[n-1][m-1]%num;

            return answer;
        }

    }
}
