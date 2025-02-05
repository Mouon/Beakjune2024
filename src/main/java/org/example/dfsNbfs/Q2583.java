package org.example.dfsNbfs;

import java.util.*;

public class Q2583 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    static int[][] area;
    static boolean[][] visited;

    static  int N,M,K;

    public static void main(String[] args) {

        int countArea = 0;
        ArrayList<Integer> results = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        area = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0;i<K;i++){
            int startX = scan.nextInt();
            int startY = scan.nextInt();
            int endX = scan.nextInt();
            int endY = scan.nextInt();

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    area[y][x] = 1;
                }
            }

        }

//        for (int y = 0; y < N; y++) {
//            for (int x = 0; x < M; x++) {
//                System.out.print(area[y][x] + " ");
//            }
//            System.out.println();
//        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if(!visited[y][x]&&area[y][x]==0){
                    results.add(bfs(y,x));
                    countArea++;
                }
            }
        }

        Collections.sort(results);
        System.out.println(countArea);

        for (Integer result : results) {
            System.out.print(result + " ");
        }

    }

    static int bfs(int y,int x){
        int count =1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            for(int k=0;k<4;k++){
                int nowX = curX + dx[k];
                int nowY = curY + dy[k];
                if(nowX>=0&&nowY>=0&&nowX<M&&nowY<N&&!visited[nowY][nowX]
                &&area[nowY][nowX]==0){
                    visited[nowY][nowX] = true;
                    queue.add(new int[]{nowY,nowX});
                    ++count;
                }

            }

        }
        return count;
    }
}
