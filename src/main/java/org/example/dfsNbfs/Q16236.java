package org.example.dfsNbfs;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q16236 {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];

            que.add(new int[]{cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;

            boolean ck = false;

            while (!que.isEmpty()) {
                cur = que.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) { // 먹이가 있으면서 상어의 사이즈보다 작다면?
                    map[cur[0]][cur[1]] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || visit[ny][nx] || map[ny][nx] > size)
                        continue;

                    que.add(new int[]{ny, nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }

            if (!ck)
                break;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }


        System.out.println(move);

    }

}
