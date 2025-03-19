package org.example.dfsNbfs;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3055 {
    public static int R;
    public static int C;
    public static String[][] box;
    static boolean[][] visited;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static Queue<Water> queue = new LinkedList<Water>();

    public static void main(String[] args) throws IOException {


        Scanner scan = new Scanner(System.in);
        R = scan.nextInt();
        C = scan.nextInt();
        visited = new boolean[R][C];
        scan.nextLine();

        box = new String[R][C];

        KAKTUS kaktus = new KAKTUS(0,0,0);
        S s= new S(0,0,0);
        for (int i = 0; i < R; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < C; j++) {
                box[i][j] = str.substring(j,j+1);
                if(box[i][j].equals("*")){
                    queue.offer(new Water(i,j,0));
                }else if(box[i][j].equals("D")){
                    kaktus = new KAKTUS(i,j,0);
                }else if(box[i][j].equals("S")){
                    s= new S(i,j,0);
                }
            }
        }


        bfs(s.x, s.y, kaktus);

    }

    static class KAKTUS{
        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        int x;
        int y;
        int minutes;

        public KAKTUS(int x, int y, int minutes){
            this.x = x;
            this.y = y;
            this.minutes = minutes;
        }
    }

    static class S{
        int x;
        int y;
        int minutes;
        public S(int x, int y, int minutes){
            this.x = x;
            this.y = y;
            this.minutes = minutes;
        }
    }

    static class Water{
        int x;
        int y;
        int minutes;

        public Water(int x, int y, int minutes){
            this.x = x;
            this.y = y;
            this.minutes = minutes;
        }
    }

    static void bfs(int x, int y,KAKTUS kaktus){
        int minutes =0;

        while (!queue.isEmpty()){
            Water w =queue.poll();
            minutes = w.minutes;
            int[] now = new int[]{w.x,w.y,w.minutes};
            for(int k=0;k<4;k++){
                int curX = now[0]+dx[k];
                int curY = now[1]+dy[k];
                if(curX>=0&&curY>=0&&curX<R&&curY<C&&!visited[curX][curY]) {
                    if (box[curX][curY].equals(".")) {
                        visited[curX][curY] = true;
                        box[curX][curY] = "*";
                        queue.add(new Water(curX, curY, minutes + 1));
                    } else if (box[curX][curY].equals("D")) {
                        visited[curX][curY] = true;
                        kaktus.setMinutes(minutes+1);
                    }
                }

            }
        }

        if(!checkKaktus(kaktus)){
            System.out.println("KAKTUS");
        }else{
            System.out.println(minutes-1);
        }
    }

    static boolean checkKaktus(KAKTUS kaktus) {
        return visited[kaktus.x][kaktus.y];
    }


}
