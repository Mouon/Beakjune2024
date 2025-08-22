package org.example.dfsNbfs;

import java.util.*;

public class Q24445 {
    static int N,M,R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited ;
    static int[] index;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        index = new int[N+1];
        visited= new boolean[N+1];

        for(int i=0;i<M;i++){
            int u = scan.nextInt();
            int v = scan.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }


        bfs(R);

        for (int i=1;i<=N;i++){
            System.out.println(index[i]);
        }

    }

    static void bfs(int start){
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            index[cur] = count++;
                for (int next : graph.get(cur)){
                    if(!visited[next]){
                        queue.add(next);
                        visited[next] = true;
                    }
                }
        }
    }
}
