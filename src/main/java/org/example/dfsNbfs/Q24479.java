package org.example.dfsNbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q24479 {
    static int N,M,R,count=1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr1=str.split(" ");
        N = Integer.parseInt(arr1[0]);
        M = Integer.parseInt(arr1[1]);
        R = Integer.parseInt(arr1[2]);
        graph = new ArrayList<>();
        visited= new boolean[N+1];
        result = new int[N+1];
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

        dfs(R);
        for(int i=1;i<=N;i++){
            System.out.println(result[i]);
        }
    }

    static void dfs(int cur){
        visited[cur]=true;
        result[cur]=count++;
        Collections.sort(graph.get(cur));

        for(int node : graph.get(cur)){
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    }

