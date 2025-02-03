package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2573 {
    static  int N,M,count,year;
    static int[][] ice, melting;
    static boolean[][] visited;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        ice = new int[N][M];
        melting = new int[N][M];

        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                ice[i][j] = scan.nextInt();
            }
        }

        while (true){
            count = 0;
            visited = new boolean[N][M];

            for(int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if(ice[i][j] > 0 && !visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            if (count == 0) {
                year = 0;
                break;
            }
            if (count >= 2) {
                break;
            }

            meltIce();
            ++year;

        }

        System.out.println(year);


    }

    static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            for(int k=0;k<4;k++){
                if(curX+dx[k]>=0&&curY+dy[k]>=0&&curX+dx[k]<N&&curY+dy[k]<M
                &&!visited[curX+dx[k]][curY+dy[k]]){
                    if(ice[curX+dx[k]][curY+dy[k]]!=0){
                        visited[curX+dx[k]][curY+dy[k]] = true;
                        queue.add(new int[]{curX+dx[k],curY+dy[k]});
                    }
                }
            }


        }
    }
    static void meltIce() {
        int[][] melting = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] > 0) {
                    int waterCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && ice[nx][ny] == 0) {
                            waterCount++;
                        }
                    }
                    melting[i][j] = waterCount;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ice[i][j] = Math.max(0, ice[i][j] - melting[i][j]);
            }
        }
    }
}


