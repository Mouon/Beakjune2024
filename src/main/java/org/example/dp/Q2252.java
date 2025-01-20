package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int former = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            adj[former].add(after);
            indegree[after]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int next : adj[current]) {
                indegree[next]--; // 진입 차수 감소
                if (indegree[next] == 0) {
                    queue.offer(next); // 진입 차수가 0이면 큐에 넣음
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
