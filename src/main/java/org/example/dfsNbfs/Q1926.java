package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1926 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    static int[][] area;
    static boolean[][] visited;

    static  int N,M;
    public static void main(String[] args) {

        int amount = 0, max =0;
        Scanner scan = new Scanner(System.in);


        N = scan.nextInt();
        M = scan.nextInt();
        area = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                area[i][j] = scan.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(!visited[i][j]&&area[i][j]==1){
                    max=Math.max(max,BFS(i,j));
                    amount++;
                }
            }
        }

        System.out.println(amount);
        System.out.println(max);




    }

    static int BFS(int x,int y) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < M
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                    if(area[curX + dx[k]][curY + dy[k]]==1){
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k]});
                        count++;
                    }

                }
            }
        }
        return count;
    }
}
