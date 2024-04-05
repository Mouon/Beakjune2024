package org.example.dfsNbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    public static int N;
    public static int M;
    public static int[][] box;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static Queue<tomato> queue = new LinkedList<tomato>();

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

    public static void main(String[] args) throws IOException {


        Scanner scan = new Scanner(System.in);

        String str =scan.nextLine();
        String[] arr=str.split(" ");
        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str2 =scan.nextLine();
            String[] arr2=str2.split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(arr2[j]);
                if(box[i][j] == 1){
                    queue.offer(new tomato(i,j,0));
                }

            }
        }

        bfs();
    }

    public static void bfs() {
        int day=0;

        while (!queue.isEmpty()){
            tomato t =queue.poll();
            int x=t.x;
            int y=t.y;
            day=t.day;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx>=0&&nx<N&&ny>=0&&ny<M){
                    if(box[nx][ny]==0){
                    box[nx][ny]=1;
                    queue.add(new tomato(nx,ny,day+1));
                    }
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