package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1240 {

    static int N,M,S,E;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();


        for (int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<N-1;i++){
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            int d = scan.nextInt();

            graph.get(u).add(new int[]{v, d});
            graph.get(v).add(new int[]{u, d});
        }

        for (int i=0;i<M;i++){
            visited = new boolean[N];
            S = scan.nextInt()-1;
            E = scan.nextInt()-1;

            dfs(S,0);
        }


    }

    static void dfs(int start,int dist){
        visited[start] = true;
        if(start == E){
            System.out.println(dist);
            return;
        }
        for (int[] edge : graph.get(start)) {
            int next = edge[0];
            int cost = edge[1];

            if (!visited[next]) {
                dfs(next, dist + cost);
            }
        }
    }

}
