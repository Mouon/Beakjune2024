package org.example.dfsNbfs;

import java.util.*;

public class Q24444 {
    static int N,M,R,Order=1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt()-1;

        visited = new boolean[N];
        dist = new int[N];

        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bfs(R);

        for (int ans : dist){
            System.out.println(ans);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = Order++;
        while (!queue.isEmpty()){
            int now = queue.poll();
            Collections.sort(graph.get(now));
            for(int next : graph.get(now)){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = Order++;
                }
            }
        }
    }
}
