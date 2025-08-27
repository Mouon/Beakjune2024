package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q17086 {
    static int n, m;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[][] arr;
    static int[][] dist; // 안전 거리 저장
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        Queue<int[]> startPoints = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
                if (arr[i][j] == 1) {
                    startPoints.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs(startPoints);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }

    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int cy = index[0];
            int cx = index[1];

            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[cy][cx] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}
