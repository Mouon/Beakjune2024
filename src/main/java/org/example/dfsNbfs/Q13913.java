package org.example.dfsNbfs;

import java.util.*;

public class Q13913 {
    static int[] graph;
    static int[] parent;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new int[100001];
        parent = new int[100001];
        visited = new boolean[100001];

        bfs(N);

        System.out.println(graph[M]);
        printPath(M);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        graph[start] = 0;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == M) return;

            int[] next = {now - 1, now + 1, now * 2};

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] < 100001 && !visited[next[i]]) {
                    queue.add(next[i]);
                    visited[next[i]] = true;
                    graph[next[i]] = graph[now] + 1;
                    parent[next[i]] = now;
                }
            }
        }
    }

    static void printPath(int target) {
        List<Integer> path = new ArrayList<>();
        while (target != -1) {
            path.add(target);
            target = parent[target];
        }
        Collections.reverse(path);

        for (int num : path) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
