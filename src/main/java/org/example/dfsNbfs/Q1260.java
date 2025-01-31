package org.example.dfsNbfs;

import java.io.IOException;
import java.util.*;

public class Q1260 {
    static int N, M, V, countDfs = 1, countBfs = 1;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static boolean[] foundBfs;


    static ArrayList<Integer> resultDfs = new ArrayList<>();
    static ArrayList<Integer> resultBfs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();

        graph = new ArrayList<>();
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];
        foundBfs = new boolean[N + 1];


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int node1;
        int node2;

        for (int i = 0; i < M; i++) {
            node1 = scan.nextInt();
            node2 = scan.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        dfs(V);

        bfs(V);

        for (int node : resultDfs){
            System.out.print(node + " ");
        }
        System.out.println();
        for (int node : resultBfs){
            System.out.print(node + " ");
        }

    }

    static void dfs(int cur) {
        visitedDfs[cur] = true;
        resultDfs.add(cur);

        Collections.sort(graph.get(cur));
        for(int node : graph.get(cur)){
            if(!visitedDfs[node]){// 역참조 방지
                dfs(node);
            }
        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visitedBfs[cur] = true;
        resultBfs.add(cur);

        while (!queue.isEmpty()){
            int nowNode = queue.poll();
            Collections.sort(graph.get(cur));
            for(int node : graph.get(nowNode)){
                if(!visitedBfs[node]){
                    visitedBfs[node] = true;
                    queue.offer(node);
                    resultBfs.add(node);
                }
            }
        }
    }
}



