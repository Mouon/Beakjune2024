package org.example.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q15681 {
    static int N, R, Q ,D;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] subtreeSize;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();

        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        subtreeSize = new int[N];

        for(int i=0;i<N-1;i++){
            int U = scan.nextInt()-1;
            int V = scan.nextInt()-1;

            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        dfs(R-1,-1);

        for(int i = 0; i < Q; i++) {
            int q = scan.nextInt();
            System.out.println(subtreeSize[q - 1]);
        }
    }

    static void dfs(int node, int parent) {
        subtreeSize[node] = 1;
        for (int child : graph.get(node)) {
            if (child != parent) { // 양방향으로 입력받았기떄문에 되돌아가는거 방지
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }
}
