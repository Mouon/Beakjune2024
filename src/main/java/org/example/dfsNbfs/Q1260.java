package org.example.dfsNbfs;

import java.io.IOException;
import java.util.*;

public class Q1260 {
    static int N, M, R, countDfs = 1, countBfs = 1;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static boolean[] foundBfs;


    static int[] resultDfs;
    static int[] resultBfs;

    public static void main(String[] args) throws IOException {

        int visitedCount=0;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr1 = str.split(" ");
        N = Integer.parseInt(arr1[0]);
        M = Integer.parseInt(arr1[1]);
        R = Integer.parseInt(arr1[2]);
        graph = new ArrayList<>();
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];
        foundBfs = new boolean[N + 1];

        resultDfs = new int[N + 1];
        resultBfs = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int u;
        int v;

        for (int i = 0; i < M; i++) {
            str = scan.nextLine();
            String[] arr2 = str.split(" ");
            u = Integer.parseInt(arr2[0]);
            v = Integer.parseInt(arr2[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R);
        bfs(R);
        for (int i = 1; i <= N; i++) {
            if (resultDfs[i] != 0) {
                System.out.print(resultDfs[i] + " ");
            }
        }
        System.out.println("");
        for (int i = 1; i <= N; i++) {
            if (resultBfs[i] != 0) {
                System.out.print(resultBfs[i] + " ");
            }
        }
    }

    static void dfs(int cur) {
        visitedDfs[cur] = true;
        resultDfs[countDfs++] = cur;
        Collections.sort(graph.get(cur));

        for (int node : graph.get(cur)) {
            if (!visitedDfs[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visitedBfs[cur]=true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            resultBfs[countBfs++]=node;

            Collections.sort(graph.get(node));
            for(int neighbor: graph.get(node)){
                if(!visitedBfs[neighbor]){
                    visitedBfs[neighbor]=true;
                    queue.offer(neighbor);
                }
            }

        }

    }
}



