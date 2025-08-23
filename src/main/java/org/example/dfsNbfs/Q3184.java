package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3184 {
    static int R,C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int wolf = 0;
    static int sheep = 0;
    static int[][] ground;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ground = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0;j<C;j++){
                String temp = line.substring(j,j+1);
                if(temp.equals(".")){
                    ground[i][j] = 0;
                }else if(temp.equals("#")){
                    ground[i][j] = 1;
                }else if(temp.equals("o")){
                    ground[i][j] = 2;
                }else if(temp.equals("v")){
                    ground[i][j] = 3;
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!visited[i][j]) search(i,j);
            }
        }

        System.out.println(sheep+" "+wolf);
    }

    static void search(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});

        int s = 0;
        int w = 0;
        while (!queue.isEmpty()){

            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            if(ground[now[0]][now[1]]==2){
                s++;
            } else if (ground[now[0]][now[1]]==3) {
                w++;
            }

            for (int k=0;k<4;k++){
                int y = now[0] + dy[k];
                int x = now[1] + dx[k];

                if(x>=0 && y>=0 && y<R&&x<C&&!visited[y][x]&&ground[y][x]!=1){
                    queue.add(new int[] {y,x});
                    visited[y][x] = true;
                }
            }
        }
        if(s>w){
            sheep +=s;
        }else {
            wolf +=w;
        }
    }

}
