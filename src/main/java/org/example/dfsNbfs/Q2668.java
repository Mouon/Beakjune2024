package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2668 {
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static boolean succeed;
    public static int[] dx = {1,  0};
    public static int[] dy = {0, 1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        area = new int[N][N];
        visited = new boolean[N][N];


        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                area[i][j] = scan.nextInt();
            }
        }

        BFS(0,0);

        if(succeed){
            System.out.println("HaruHaru");
        }else {
            System.out.println("Hing");
        }

    }

    static void BFS(int x,int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            if(area[curX][curY]==-1){
                succeed = true;
                return;
            }
            int jump = area[curX][curY];

            for (int k = 0; k < 2; k++) {
                int nextX = curX + dx[k] * jump;
                int nextY = curY + dy[k] * jump;
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
                        && !visited[nextX][nextY]) {
                    visited[curX + dx[k]][curY + dy[k]] = true;
                    queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
}
