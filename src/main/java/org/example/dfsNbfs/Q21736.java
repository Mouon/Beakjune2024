package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q21736 {
    static int N,M, count = 0;
    static String[][] map;
    static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        map = new String[N][M];
        visited = new boolean[N][M];

        scan.nextLine();

        int[] me = new int[2];

        for(int i=0;i<N;i++){
            String line = scan.nextLine();
            for (int j=0;j<M;j++){
                map[i][j] = line.substring(j,j+1);
                if(map[i][j].equals("I")){
                    me = new int[]{i,j};
                }
            }
        }

        BFS(me[0],me[1]);

        if(count==0){
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            for (int k = 0; k < 4; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < N
                        && curY + dy[k] < M
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                    if(!map[curX + dx[k]][curY + dy[k]].equals("X")){
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k], curY + dy[k]});
                        if(map[curX + dx[k]][curY + dy[k]].equals("P")){
                            count ++;
                        }
                    }
                }
            }
        }
    }
}
