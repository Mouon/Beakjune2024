package org.example.dfsNbfs;

import java.util.*;

public class Q1325 {
    static ArrayList<ArrayList<Integer>> com = new ArrayList<>();
    static int N,M,maxCount = 0;
    static int[] hackingCount;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N+1];
        hackingCount = new int[N+1];

        for(int i=0; i<=N; i++){
            com.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();

            com.get(B).add(A);
        }

        for (int node=1;node<=N;node++){
            if(!visited[node]){
                hackingCount[node] = BFS(node);
                maxCount = Math.max(maxCount,hackingCount[node]);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (hackingCount[i] == maxCount) {
                System.out.print(i + " ");
            }
        }


    }

    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int count = 1;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : com.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
