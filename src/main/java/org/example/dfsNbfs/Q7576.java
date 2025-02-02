package org.example.dfsNbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    public static int N;
    public static int M;
    public static int[][] box;
    static boolean[][] visited;
    static int count = 1000000;
    static boolean allGood;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static Queue<tomato> queue = new LinkedList<tomato>();


    public static void main(String[] args) throws IOException {


        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        visited = new boolean[N][M];

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = scan.nextInt();
                if(box[i][j] == 1){
                    queue.offer(new tomato(i,j,0));
                }
            }
        }

        bfs();
    }

    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static void bfs(){
        int day =0;

        while (!queue.isEmpty()){
            tomato t =queue.poll();
            day=t.day;
            int[] now = new int[]{t.x,t.y};
            for(int k=0;k<4;k++){
                int curX = now[0]+dx[k];
                int curY = now[1]+dy[k];
                if(curX>=0&&curY>=0&&curX<N&&curY<M&&!visited[curX][curY]
                        &&box[curX][curY]==0){
                    visited[curX][curY]=true;
                    box[curX][curY]=1;
                    queue.add(new tomato(curX,curY,day+1));
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
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }



}