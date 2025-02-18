package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q18352 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N,M,K,X;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        X = scan.nextInt();

        for (int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0;i<M; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();

            graph.get(A).add(B);
        }

        BFS(X);

        for(int i=0;i<=N;i++){
            if(dist[i]==K){
                ans.add(i);
            }
        }

        if(ans.isEmpty()){
            ans.add(-1);
        }

        for(int out : ans){
            System.out.println(out);
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[now]+1;
                }
            }
        }
    }
}
