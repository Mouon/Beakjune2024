package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11403 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                graph[i][j] = scan.nextInt();
            }
        }

        // 거쳐가서 갈 수 있으면 1로 갱신
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]&&graph[i][j]!=1){
                    graph[i][j]=1;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }
}
