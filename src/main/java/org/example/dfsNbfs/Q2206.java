package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2206 {

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int N,M, count=0;
    static int[][] miro;
    static int[][] distance;
    static boolean[][][] visited;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        miro = new int[N][M];
        visited = new boolean[N][M][2];
        distance = new int[N][M];

        scan.nextLine();

        for(int i=0;i<N;i++){
            String line = scan.nextLine();
            for(int j=0;j<M;j++){
                miro[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }



        int result = BFS(0, 0);

        System.out.println(result);


    }

    static int BFS(int i ,int j) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        visited[i][j][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            int broken = now[2];

            if (curX == N - 1 && curY == M - 1) {
                return miro[curX][curY] + 1;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

                    // 벽을 부수지 않은 상태에서 벽을 만난 경우
                    if (miro[nextX][nextY] == 1 && broken == 0 && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                        queue.add(new int[]{nextX, nextY, 1});
                    }
                    // 벽을 부수지 않고 이동
                    if (miro[nextX][nextY] == 0 && !visited[nextX][nextY][broken]) {
                        visited[nextX][nextY][broken] = true;
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                        queue.add(new int[]{nextX, nextY, broken});
                    }
                }
            }
        }
        return -1;
    }


}
