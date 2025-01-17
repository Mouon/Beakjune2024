package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3584 {
    static ArrayList<ArrayList<Integer>> graph = new java.util.ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        for(int j=0;j<N;j++) {

            int M = scan.nextInt();

            parent = new int[M + 1];

            graph = new ArrayList<>();

            for (int i = 0; i <= M; i++) {
                graph.add(new ArrayList<Integer>());
                parent[i] = i;
            }

            for (int i = 0; i < M-1; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                parent[v] = u;
            }

            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            int current = num1;

            visited = new boolean[M + 1];

            while (current != parent[current]) {
                visited[current] = true;
                current = parent[current];
            }
            current = num2;
            while (current != parent[current]) {
                if (visited[current]) {
                    System.out.println(current);
                    break;
                }
                current = parent[current];
            }

            if (current == parent[current]) {
                System.out.println(current);
            }

        }

    }
}
