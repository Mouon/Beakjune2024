package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11060 {
    static int[] miro, dist;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        miro = new int[N];
        dist = new int[N];
        visited = new boolean[N];

        for (int i=0;i<miro.length;i++){
            miro[i] = scan.nextInt();
        }

        bfs();

        if(!visited[N-1]){
            System.out.println(-1);
        }else {
            System.out.println(dist[N-1]);
        }

    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=1;i<=miro[now];i++){
                int next = now+i;
                if(next<N&&!visited[next]){
                    queue.add(next);
                    dist[next] = dist[now]+1;
                    visited[next] = true;
                }
            }
        }
    }
}
