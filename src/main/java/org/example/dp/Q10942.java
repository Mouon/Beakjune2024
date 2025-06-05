package org.example.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Q10942 {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            dp[i][i] = true;
        }

        for(int i=1; i<=N-1; i++) {
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        isPalindrome();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? "1\n" : "0\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void isPalindrome(){
        for(int i=2; i<N; i++) {
            for(int j=1; j<=N-i; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) { // 새로추가된거랑 기존 수열의 처음과 수가 같고, 그 사이의 숫자들이 이미 팰린드롬이다.
                    dp[j][j+i] = true;
                }
            }
        }
    }
}
