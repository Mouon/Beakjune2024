package org.example.dfsNbfs;

import java.util.*;

/**
 * BFS 로 그래프 연결 요소 찾는 문제다.
 * */
public class Q2667 {
    static int N;
    static int[][] apt ;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean[][] visited;

    static ArrayList<Integer> dan = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        visited = new boolean[N][N];
        apt = new int[N][N];

        scan.nextLine();

        for(int i=0; i<N; i++){
            String line = scan.nextLine();
            for(int j=0;j<N;j++){
                apt[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&&apt[i][j]!=0){
                    dan.add(bfs(i,j));
                }
            }
        }

        Collections.sort(dan);

        System.out.println(dan.size());
        for(int count : dan){
            System.out.println(count);
        }

    }

    static int bfs(int i,int j){
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = new int[]{i, j};
        queue.add(arr);
        visited[i][j]=true;
        int count = 1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                if(x>=0&&x<N&&y>=0&&y<N&&!visited[x][y]&&apt[x][y]!=0){
                    visited[x][y]=true;
                    queue.add(new int[]{x,y});
                    count++;
                }
            }

        }
        return count;
    }
}
