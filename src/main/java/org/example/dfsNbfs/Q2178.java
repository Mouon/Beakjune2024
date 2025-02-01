package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178  {
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};

        static int N,M;
        static int[][] miro;
        static boolean[][] visited;


    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro =new int[N][M];
        visited = new boolean[N][M];

        /**
         * 미로 채우기
         * */
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
          for (int j=0;j<M;j++){
              miro[i][j] = Integer.parseInt(line.substring(j,j+1));
          }
        }

        search(0,0);
        System.out.println(miro[N-1][M-1]);


    }

    static void search(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        while (!queue.isEmpty()){

            int now[] = queue.poll();
            visited[i][j] = true;

            for(int l=0;l<4;l++) {

                int x = now[0] + dx[l];
                int y = now[1] + dy[l];

                if(x>=0 && y>=0 && x<N && y<M){
                    if(miro[x][y]!=0&&!visited[x][y]){
                        visited[x][y] = true;
                        miro[x][y] += miro[now[0]][now[1]];
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    static void search2 (int i, int j){

        visited[i][j] = true;

            for(int l=0;l<4;l++) {

                int x = i + dx[l];
                int y = j + dy[l];

                if(x>=0 && y>=0 && x<N && y<M){
                    if(miro[x][y]!=0&&!visited[x][y]){
                        visited[x][y] = true;
                        miro[x][y] += miro[i][j];
                        search2(x,y);
                    }
                }
            }
        }

}
