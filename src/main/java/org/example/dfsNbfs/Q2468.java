package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2468 {
    static int N, count=0,result=0;
    static int[][] area;
    static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        area = new int[N][N];
        visited = new boolean[N][N];

        int max =0;

        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                area[i][j] = scan.nextInt();
                if(max<area[i][j]){
                    max = area[i][j];
                }
            }
        }

        int k = 0;
        while (true){

            count = 0;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if(!visited[i][j]&&area[i][j]>=k){
                        BFS(i,j,k);
                        count++;
                    }
                }
            }
            result = Math.max(result,count);

            k++;

            if(k>max){
                break;
            }

        }

        System.out.println(result);

    }

    static void BFS(int x,int y,int high) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < N
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                    if(area[curX + dx[k]][curY + dy[k]]>=high){
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k]});
                    }

                }
            }
        }
    }

}
