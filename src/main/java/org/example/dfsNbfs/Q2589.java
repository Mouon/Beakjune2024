package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2589 {
    static int H,W,MAX=0;
    static int[][] map, dist;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        H = scan.nextInt();
        W = scan.nextInt();

        scan.nextLine();

        map = new int[H][W];
        dist = new int[H][W];
        visited = new boolean[H][W];

        for(int i=0;i<H;i++){
            String line = scan.nextLine();
            for (int j=0;j<W;j++){
                String now = line.substring(j,j+1);
                if(now.equals("W")){
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0;i<H;i++){
            for (int j=0;j<W;j++){
                visited = new boolean[H][W];
                dist = new int[H][W];
                if(map[i][j] == 0){
                    bfs(i,j);
                }
            }
        }

        System.out.println(MAX);


    }

    static void bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            for(int k=0;k<4;k++){
                int nowX = curX + dx[k];
                int nowY = curY + dy[k];
                if(nowX>=0&&nowY>=0&&nowX<W&&nowY<H&&!visited[nowY][nowX]
                        &&map[nowY][nowX]==0){
                    visited[nowY][nowX] = true;
                    queue.add(new int[]{nowY,nowX});
                    dist[nowY][nowX] = dist[curY][curX] + 1;
                    if(MAX < dist[nowY][nowX]){
                        MAX = dist[nowY][nowX];
                    }
                }

            }

        }
    }

}
