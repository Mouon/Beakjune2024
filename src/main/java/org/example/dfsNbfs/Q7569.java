package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7569 {
    static int M, N, H;
    public static int[][][] box;
    static boolean[][][] visited;

    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};


    public static Queue<tomato> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        visited = new boolean[H][N][M];
        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = scan.nextInt();
                    if (box[i][j][k] == 1) {
                        queue.offer(new tomato(k, j, i, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

    }

    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;
            int[] now = new int[]{t.x, t.y, t.z};
            for (int k = 0; k < 6; k++) {
                int curX = t.x + dx[k];
                int curY = t.y + dy[k];
                int curZ = t.z + dz[k];

                if (curX >= 0 && curY >= 0 && curZ >= 0 && curX < M && curY < N && curZ < H
                        && !visited[curZ][curY][curX] && box[curZ][curY][curX] == 0) {
                    visited[curZ][curY][curX] = true;
                    box[curZ][curY][curX] = 1;
                    queue.add(new tomato(curX, curY, curZ, day + 1));
                }
            }
        }

        if(!checkTomato()){
            System.out.println("-1");
        }else{
            System.out.println(day);
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class tomato{
        int x;
        int y;
        int z;
        int day;

        public tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}
