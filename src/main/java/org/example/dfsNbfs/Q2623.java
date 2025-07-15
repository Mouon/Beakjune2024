package org.example.dfsNbfs;

import java.util.*;

public class Q2623{
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        indegree = new int[N + 1];

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 아 이해함
        for(int i = 0; i < M; i++) {
            int count = scan.nextInt();
            if(count == 0) continue;
            int x = scan.nextInt();
            for(int j = 0; j < count - 1; j++) {
                int y = scan.nextInt();
                indegree[y]++;
                graph[x].add(y);
                x = y;
            }
        }

        solution();

    }

    public static void solution(){
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i<=N; i++){
            if (indegree[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            answer.add(x);
            for(int y : graph[x]){
                indegree[y]--;
                if(indegree[y] == 0) queue.add(y);
            }
        }

        if(answer.size() != N) System.out.println(0);
        else {
            for(int x : answer) {
                System.out.println(x);
            }
        }

    }

}
