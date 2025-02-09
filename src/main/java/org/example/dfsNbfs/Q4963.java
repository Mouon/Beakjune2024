package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4963 {
    static int W,H;
    static int[][] area;
    static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0,1, -1, -1, 1};
    public static int[] dy = {0, 0, 1, -1,1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();

        while (true){
            int count = 0;
            W = scan.nextInt();
            H = scan.nextInt();

            if(W==0&&H==0) break;

            area = new int[H][W];
            visited = new boolean[H][W];

            for (int i =0;i<H;i++){
                for (int j=0;j<W;j++){
                    area[i][j] = scan.nextInt();
                }
            }

            for (int i =0;i<H;i++){
                for (int j=0;j<W;j++){
                    if(!visited[i][j]&&area[i][j]==1){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            results.add(count);
        }

        for (int ans : results){
            System.out.println(ans);
        }
    }

    static void BFS(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();;
            int curX = now[1];
            int curY = now[0];
            for (int k = 0; k < 8; k++) {
                if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < W
                        && curY + dy[k] < H
                        && !visited[curY + dy[k]][curX + dx[k]]) {
                    if(area[curY + dy[k]][curX + dx[k]]==1){
                        visited[curY + dy[k]][curX + dx[k]] = true;
                        queue.add(new int[]{curY + dy[k],curX + dx[k]});
                    }
                }
            }
        }
    }
}


/**
* package org.example.dfsNbfs;
 *
 * import java.util.ArrayList;
 * import java.util.LinkedList;
 * import java.util.Queue;
 * import java.util.Scanner;
 *
 * public class Q4963 {
 *     static int W,H;
 *     static int[][] area;
 *     static boolean[][] visited;
 *     public static int[] dx = {1, -1, 0, 0,1, -1, -1, 1};
 *     public static int[] dy = {0, 0, 1, -1,1, -1, 1, -1};
 *
 *     public static int[] dx2 = {1, -1, -1, 1};
 *     public static int[] dy2 = {1, -1, 1, -1};
 *
 *     public static void main(String[] args) {
 *         Scanner scan = new Scanner(System.in);
 *         ArrayList<Integer> results = new ArrayList<>();
 *
 *         while (true){
 *             int count = 0;
 *             W = scan.nextInt();
 *             H = scan.nextInt();
 *
 *             if(W==0&&H==0) break;
 *
 *             area = new int[H][W];
 *             visited = new boolean[H][W];
 *
 *             for (int i =0;i<H;i++){
 *                 for (int j=0;j<W;j++){
 *                     area[i][j] = scan.nextInt();
 *                 }
 *             }
 *
 *             for (int i =0;i<H;i++){
 *                 for (int j=0;j<W;j++){
 *                     if(!visited[i][j]&&area[i][j]==1){
 *                         BFS(i,j);
 *                         count++;
 *                     }
 *                 }
 *             }
 *             results.add(count);
 *         }
 *
 *         for (int ans : results){
 *             System.out.println(ans);
 *         }
 *     }
 *
 *     static void BFS(int y,int x){
 *         Queue<int[]> queue = new LinkedList<>();
 *         queue.add(new int[]{y,x});
 *         visited[y][x] = true;
 *
 *         while (!queue.isEmpty()){
 *             int[] now = queue.poll();;
 *             int curX = now[1];
 *             int curY = now[0];
 *             for (int k = 0; k < 4; k++) {
 *                 if (curX + dx[k] >= 0 && curY + dy[k] >= 0 && curX + dx[k] < W
 *                         && curY + dy[k] < H
 *                         && !visited[curY + dy[k]][curX + dx[k]]) {
 *                     if(area[curY + dy[k]][curX + dx[k]]==1){
 *                         visited[curY + dy[k]][curX + dx[k]] = true;
 *                         queue.add(new int[]{curY + dy[k],curX + dx[k]});
 *                     }
 *                 }
 *             }
 *             for (int k = 0; k < 4; k++) {
 *                 if (curX + dx2[k] >= 0 && curY + dy2[k] >= 0 && curX + dx2[k] < W
 *                         && curY + dy2[k] < H
 *                         && !visited[curY + dy2[k]][curX + dx2[k]]) {
 *                     if(area[curY + dy2[k]][curX + dx2[k]]==1){
 *                         visited[curY + dy2[k]][curX + dx2[k]] = true;
 *                         queue.add(new int[]{curY + dy2[k],curX + dx2[k]});
 *                     }
 *                 }
 *             }
 *         }
 *     }
 * }
 * */
