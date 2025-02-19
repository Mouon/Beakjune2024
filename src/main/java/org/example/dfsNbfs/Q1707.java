package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1707 {
    static int K,V,E;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean isBinary;
    static int[] color;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        K = scan.nextInt();

        for (int i=0;i<K;i++){
            V = scan.nextInt();
            E = scan.nextInt();

            graph = new ArrayList<>();
            color = new int[V];

            for (int j=0;j<V;j++){
                graph.add(new ArrayList<>());
                color[j] = 0;
            }

            for (int e=0;e<E;e++){
                int u = scan.nextInt()-1;
                int v = scan.nextInt()-1;

                graph.get(u).add(v);
                graph.get(v).add(u);

            }

            isBinary = true;
            for (int v = 0; v < V; v++) {
                if (color[v] == 0) {
                    DFS(v, 1);
                }
            }
            if(isBinary){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    static void DFS(int start,int c){
        color[start] = c;

        for(int next : graph.get(start)){
            if(color[next]==0){
                DFS(next,-c);
            }else if (color[next] == color[start]) {
                isBinary = false;
                return;
            }

        }
    }
}
