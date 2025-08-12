package org.example.listNArray;
import java.util.*;

public class 위상정렬_템플릿 {
    public static void main(String[] args) {
        int N = 6; // 노드 개수
        List<Integer>[] graph = new ArrayList[N+1];
        int[] inDegree = new int[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 예시 간선 입력
        addEdge(graph, inDegree, 1, 2);
        addEdge(graph, inDegree, 1, 5);
        addEdge(graph, inDegree, 2, 3);
        addEdge(graph, inDegree, 3, 4);
        addEdge(graph, inDegree, 5, 6);

        // 위상 정렬
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // 1. 진입차수 0인 노드 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        // 2. 큐에서 꺼내면서 처리
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int next : graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.add(next);
            }
        }

        // 3. 사이클 판별
        if (result.size() != N) {
            System.out.println("Cycle exists!");
        } else {
            System.out.println(result);
        }
    }

    static void addEdge(List<Integer>[] g, int[] deg, int from, int to) {
        g[from].add(to);
        deg[to]++;
    }
}
