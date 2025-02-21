package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5567 {
    static int N,M,count=0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;

        for (int next : graph.get(0)){
            queue.add(next);
            if(!visited[next]){
                count++;
                visited[next]=true;
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            BFS(now);
        }

        System.out.println(count);

    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int next : graph.get(now)){
                if(!visited[next]){
                    visited[next]=true;
                    count++;
                }
            }
        }
    }
}
