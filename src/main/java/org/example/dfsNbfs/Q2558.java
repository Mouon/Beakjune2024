package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q2558 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N,M,ans=0;
    static boolean[] visited;
    static boolean[][] check;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N+1];
        check = new boolean[N+1][N+1];


        for(int i=0;i<M;i++){
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1;
            check[a][b] = true;
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(check[i][j] || check[j][i]) {
                    cnt[i]++;
                }
            }
        }

        for(int num : cnt){
            if(num==N-1){
                ans ++;
            }
        }
        System.out.println(ans);


    }

}
