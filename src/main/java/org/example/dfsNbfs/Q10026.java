package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10026 {
    static int N;
    static String[][] grid;
    static int[][] area,area2;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited,visited2;


    public static void main(String[] args) {

        int count = 0;
        int count2 = 0;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        grid = new String[N][N];
        area = new int[N][N];
        area2 = new int[N][N];

        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        scan.nextLine();

        for(int i=0;i<N;i++){
            String line = scan.nextLine();
            for(int j=0;j<N;j++){
                grid[i][j] = line.substring(j,j+1);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j].equals("R")){
                    area[i][j] = 1;
                }else if(grid[i][j].equals("G")){
                    area[i][j] = 2;
                }else {
                    area[i][j] = 3;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j].equals("R")||grid[i][j].equals("G")){
                    area2[i][j] = 1;
                }else {
                    area2[i][j] = 3;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS(i,j,area[i][j]);
                    count++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited2[i][j]){
                    BFS2(i,j,area2[i][j]);
                    count2++;
                }
            }
        }

        System.out.print(count+" "+count2);


    }

    static void BFS(int x,int y,int code){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,code});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < N
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                    if(area[curX + dx[k]][curY + dy[k]]==code){
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k],area[curX + dx[k]][curY + dy[k]]});
                    }

                }
            }
        }

    }

    static void BFS2(int x,int y,int code){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,code});
        visited2[x][y] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < N
                        && !visited2[curX + dx[k]][curY + dy[k]]) {
                    if(area2[curX + dx[k]][curY + dy[k]]==code){
                        visited2[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k],area2[curX + dx[k]][curY + dy[k]]});
                    }

                }
            }
        }

    }
}
