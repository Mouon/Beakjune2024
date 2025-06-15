package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17404 {
    static int N;
    static ArrayList<ArrayList<Integer>> home = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            home.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            home.get(i).add(Integer.parseInt(st.nextToken()));
            home.get(i).add(Integer.parseInt(st.nextToken()));
            home.get(i).add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solve());

    }

    /**
     * 첫번째 집을 고정 시켜두고 나머지 집을 탐색
     * */
    public static int solve(){
        final int INF = 1000 * 1000;
        int result = INF;

        for(int firstColor = 0; firstColor < 3; firstColor++){
            int[][] dp = new int[N][3];

            for (int i = 0; i < 3; i++) {
                if (i == firstColor) dp[0][i] = home.get(0).get(i);
                else dp[0][i] = INF;
            }

            for(int i = 1; i<N; i++){
                dp[i][0] = home.get(i).get(0) + Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = home.get(i).get(1) + Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = home.get(i).get(2) + Math.min(dp[i-1][0],dp[i-1][1]);
            }

            for(int lastColor = 0; lastColor <3; lastColor++){
                if(lastColor != firstColor){
                    result = Math.min(result, dp[N-1][lastColor]);
                }
            }
        }

        return result;
    }
}
