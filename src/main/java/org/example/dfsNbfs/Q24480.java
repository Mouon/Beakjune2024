package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q24480 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] order;
    static int N,M,R,C=1;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();

        for (int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        order = new int[N+1];

        visited = new boolean[N+1];

        for (int i = 0;i<M; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        DFS(R);

        for (int i = 1;i< order.length; i++){
            System.out.println(order[i]);
        }

    }
    static void DFS(int start){
        visited[start] = true;
        order[start] = C++;

        Collections.sort(graph.get(start),Collections.reverseOrder());
        for(int next : graph.get(start)){
            if(!visited[next]){
                DFS(next);
            }
        }
    }
}
