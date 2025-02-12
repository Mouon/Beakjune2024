package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1068 {
    static int N, D ,count = 0,p;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        visited = new boolean[N];

        for (int i=0;i<N;i++){
            tree.add(new ArrayList<>());
        }

        p =0;
        for(int i=0;i<N;i++){
            int parent = scan.nextInt();
            if(parent!=-1){
                tree.get(parent).add(i);
            }else {
                p = i;
            }
        }

        D = scan.nextInt();

        DFS(p);

        System.out.println(count);

    }

    static void DFS(int node){
        if(visited[node]){
            return;
        }
        if(node == D){
            return;
        }
        visited[node]=true;

        boolean leaf = true ;
        for(int now : tree.get(node)){
            if(now != D){
                leaf = false;
            }
            DFS(now);
        }

        if(leaf) count++;
    }
}
