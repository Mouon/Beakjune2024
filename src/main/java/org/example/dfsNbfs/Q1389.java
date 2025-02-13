package org.example.dfsNbfs;

import java.util.*;

public class Q1389 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[][] visited;
    static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int min = Integer.MAX_VALUE;
        int resultUser = -1;

        for (int i = 1; i <= N; i++) {
            int sum = BFS(i);
            if (sum < min) {
                min = sum;
                resultUser = i;
            }
        }

        System.out.println(resultUser);
    }

    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }

}
