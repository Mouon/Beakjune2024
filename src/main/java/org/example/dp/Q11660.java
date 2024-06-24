package org.example.dp;

import java.io.IOException;
import java.util.Scanner;

public class Q11660 {

    static int dp[][];
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int num = scan.nextInt();
        int[] sol = new int[num];
        dp=new int[N+1][N+1];
        int[][] matrix = new int[N + 1][N + 1];

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                matrix[i][j]=scan.nextInt();
            }
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1]+matrix[i][j]-dp[i-1][j-1];
            }
        }


        for(int i=0;i<num;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            int z=scan.nextInt();
            int w=scan.nextInt();

            sol[i]=dp[z][w]-dp[x-1][w]-dp[z][y-1]+dp[x-1][y-1];

        }
        for(int i=0;i<num;i++){
            System.out.println(sol[i]);
        }
    }
}
