package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1012 {
    static int T,M,N,K;
    static int[][] area;
    static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);

        T = scan.nextInt();
        int[] ans = new int[T];

        for(int t=0;t<T;t++){
            int count = 0;
            M = scan.nextInt();
            N = scan.nextInt();
            K = scan.nextInt();

            area = new int[N][M];
            visited = new boolean[N][M];


            for(int i=0;i<K;i++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                area[y][x] = 1;
            }

            for(int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if(!visited[i][j]&&area[i][j]==1){
                        BFS(i,j);
                        count++;
                    }
                }
            }

            ans[t] = count;
        }

        for (int result : ans){
            System.out.println(result);
        }

    }

    static void BFS(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();;
            int curX = now[1];
            int curY = now[0];
            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < M
                        && curY + dy[k] < N
                        && !visited[curY + dy[k]][curX + dx[k]]) {
                    if(area[curY + dy[k]][curX + dx[k]]==1){
                        visited[curY + dy[k]][curX + dx[k]] = true;
                        queue.add(new int[]{curY + dy[k],curX + dx[k]});
                    }
                }
            }
        }
    }
}
