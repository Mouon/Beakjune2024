package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {
    static int T,L,sX,sY,eX,eY;
    static int[][] area;
    static boolean[][] visited;
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        T = scan.nextInt();

        for(int i=0;i<T;i++){
            L = scan.nextInt();
            area = new int[L][L];
            visited = new boolean[L][L];

            sX = scan.nextInt();
            sY = scan.nextInt();
            eX = scan.nextInt();
            eY = scan.nextInt();

            BFS(sX,sY);
            System.out.println(area[eX][eY]);
        }
    }

    static void BFS(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;


        while (!queue.isEmpty()){
            int[] now = queue.poll();;
            int curX = now[0];
            int curY = now[1];
            for (int k = 0; k < 8; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < L
                        && curY + dy[k] < L
                        && !visited[curX + dx[k]][curY + dy[k]]) {
                        visited[curX + dx[k]][curY + dy[k]] = true;
                        queue.add(new int[]{curX + dx[k],curY + dy[k]});
                        area[curX + dx[k]][curY + dy[k]] = area[curX][curY] + 1;
                }
            }
        }
    }

}
