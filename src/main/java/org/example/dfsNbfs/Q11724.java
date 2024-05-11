package org.example.dfsNbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q11724 {
    static int N,M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args)  {

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

    }

    static void dfs(int cur){
        visited[cur]=true;
        Collections.sort(graph.get(cur));

        for(int node : graph.get(cur)){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}
