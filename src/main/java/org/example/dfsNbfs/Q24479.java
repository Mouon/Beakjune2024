package org.example.dfsNbfs;

import java.io.IOException;
import java.util.*;

public class Q24479 {
    static int N,M,R,count=0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr1=str.split(" ");
        N = Integer.parseInt(arr1[0]);
        M = Integer.parseInt(arr1[1]);
        graph = new ArrayList<>();
        visited= new boolean[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<Integer>());
        }

        int u;
        int v;

        for(int i=0;i<M;i++){
            str = scan.nextLine();
            String[] arr2=str.split(" ");
            u=Integer.parseInt(arr2[0]);
            v=Integer.parseInt(arr2[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur]=true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            Collections.sort(graph.get(node));
            for(int neighbor: graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }

        }

    }


}


