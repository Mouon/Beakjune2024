package org.example.dfsNbfs;

import java.util.*;

public class Q2606 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        visited = new boolean[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<M;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(1);
        System.out.println(count);
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.offer(neighbor); // 이웃한거 목록에 추가
                    count++;
                }
            }
        }
    }
}
