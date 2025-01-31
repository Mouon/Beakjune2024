package org.example.dfsNbfs;

import java.util.*;

public class Q11724 {
    static int N,M,count = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args)  {

        Scanner scan =  new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for(int i = 1;i<N+1;i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    static void bfs(int cur){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            Collections.sort(graph.get(node));
            for(int friend : graph.get(node)){
                if(!visited[friend]){
                    visited[friend] = true;
                    queue.offer(friend);
                }
            }
        }
    }
}
