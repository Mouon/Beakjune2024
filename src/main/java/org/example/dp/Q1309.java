package org.example.dp;

import java.util.Scanner;

public class Q1309 {
    static int N;
    static int[][] uri;
    static int MOD = 9901;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        uri = new int[N][3];

        uri[0][0] = 1;
        uri[0][1] = 1;
        uri[0][2] = 1;

        for(int i = 1; i < N; i++){
            uri[i][0] = ((uri[i-1][0] + uri[i-1][1])%MOD + uri[i-1][2])%MOD;
            uri[i][1] = (uri[i-1][0] + uri[i-1][2])%MOD;
            uri[i][2] = (uri[i-1][0] + uri[i-1][1])%MOD;
        }

        System.out.println(((uri[N-1][0]+uri[N-1][1])%MOD +uri[N-1][2])%MOD );

    }
}
