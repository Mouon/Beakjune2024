package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11049 {
    static int N;
    static int[][] dp;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][2];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());

    }

    public static int solve(){
        for(int len = 1; len < N; len++){
            for(int i = 0; i + len < N; i++){
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++){
                    /**
                     * AB를 먼저 곱하고 C를 곱하는 경우 (AB)C에 필요한 곱셈 연산의 수는
                     * 5×3×2 + 5×2×6 = 30 + 60 = 90번이다.
                     * BC를 먼저 곱하고 A를 곱하는 경우 A(BC)에 필요한 곱셈 연산의 수는
                     * 3×2×6 + 5×3×6 = 36 + 90 = 126번이다.
                     * */
                    int cost = dp[i][k] + dp[k+1][j]
                            + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][N-1];
    }
}
