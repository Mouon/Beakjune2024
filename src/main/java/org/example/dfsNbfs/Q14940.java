package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14940 {
    static int N,M;
    static int[][] area;
    static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        area = new int[N][M];
        visited = new boolean[N][M];


        int x=0,y=0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                area[i][j] = scan.nextInt();
                if(area[i][j]==2){
                    x = i;
                    y = j;
                }
            }
        }

        area[x][y] = 0;
        BFS(x,y);

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(!visited[i][j]&&area[i][j]!=0){
                    area[i][j]=-1;
                }
            }
        }

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.print(area[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y]=true;
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < M
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                    if(area[curX + dx[k]][curY + dy[k]]!=2&&area[curX + dx[k]][curY + dy[k]]!=0){
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k]});
                        area[curX + dx[k]][curY + dy[k]] = area[curX][curY]+1;
                    }
                }
            }
        }    }
}
