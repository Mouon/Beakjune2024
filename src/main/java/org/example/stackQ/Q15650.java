package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            for(int j=i;j<=K;j++){
                arr[i][j]=j;
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=i;j<=K;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
