package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16948 {
    static int N, r1, c1 ,r2, c2;
    static int[][] graph;
    static boolean[][] visited;
    static int[] R = {-2,-2,0,0,2,2};
    static int[] C = {-1,1,-2,2,-1,1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        graph = new int[N][N];
        visited = new boolean[N][N];

        r1 = scan.nextInt();
        c1 = scan.nextInt();
        r2 = scan.nextInt();
        c2 = scan.nextInt();


        search(r1,c1);
        if(graph[r2][c2] == 0){
            graph[r2][c2] = -1;
        }
        System.out.println(graph[r2][c2]);

    }

    static void search(int i,int j){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i,j});

        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            if(arr[0]==r2&&arr[1]==c2){
                return;
            }
            visited[arr[0]][arr[1]] = true;

            for(int k=0;k<6;k++){
                int y = arr[0] + R[k];
                int x = arr[1] + C[k];

                if(y>=0&&x>=0&&y<N&&x<N&&!visited[y][x]){
                    queue.add(new int[]{y,x});
                    visited[y][x] = true;
                    graph[y][x] += graph[arr[0]][arr[1]]+1;
                }
            }
        }


    }
}
