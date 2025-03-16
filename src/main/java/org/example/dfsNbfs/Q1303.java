package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1303 {
    static int N,M,W=0,B=0;
    static String[][] map;
    static int[] dx ={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();

        map = new String[M][N];
        visited  = new boolean[M][N];

        for(int i=0;i<M;i++){
            String str = scan.nextLine() + " ";
            for(int j=0;j<N;j++){
                map[i][j] = str.substring(j,j+1);
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&&map[i][j].equals("W")){
                    W += bfs(i,j,"W");
                }
            }
        }

        visited  = new boolean[M][N];

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&&map[i][j].equals("B")){
                    B += bfs(i,j,"B");
                }
            }
        }

        System.out.print(W+" "+B);

    }

    static int bfs(int h,int w, String team){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{w,h});
        visited[h][w] = true;
        int count = 1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i=0;i<4;i++){
                int nextW = now[0] + dx[i];
                int nextH = now[1] + dy[i];

                if(nextW>=0&&nextW<N&&nextH>=0&&nextH<M
                        &&!visited[nextH][nextW]&&map[nextH][nextW].equals(team)){
                    queue.add(new int[]{nextW,nextH});
                    visited[nextH][nextW] = true;
                    count++;
                }
            }

        }

        return (int) Math.pow(count,2);
    }
}
