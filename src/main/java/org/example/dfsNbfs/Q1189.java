package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1189 {
    static int r,c,k;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static String[][] arr;
    static boolean[][] visited;
    static int ans =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        visited = new boolean[r][c];

        for (int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            String sts = st.nextToken();
            for (int j=0;j<c;j++){
                arr[i][j] = sts.substring(j,j+1);
            }
        }

        dfs(r-1,0,1);

        System.out.println(ans);
    }

    public static void dfs(int y,int x,int dist){
        visited[y][x] = true;
        if(y==0 && x==c-1&&dist==k){
            ans++;
            visited[y][x] = false;
            return;
        }

        for (int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny>=0 && ny<r && nx>=0
                    && nx<c && !arr[ny][nx].equals("T")&&!visited[ny][nx] ){
                dfs(ny,nx,dist+1);
            }
        }
        visited[y][x] = false;
    }
}
