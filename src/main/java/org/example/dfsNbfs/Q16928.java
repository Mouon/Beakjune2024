package org.example.dfsNbfs;

import java.util.*;

public class Q16928 {
    static int[] index = new int[100];
    static int N,M;
    static boolean[] visited = new boolean[100];
    static ArrayList<ArrayList<Integer>> snake = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();


        for(int i=0;i<100;i++){
            snake.add(new ArrayList<>());
        }

        Arrays.fill(index, Integer.MAX_VALUE);
        index[0] = 0;

        for(int i=0;i<M+N;i++){
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            snake.get(u).add(v);
        }


        BFS(0);

        System.out.println(index[99]);

    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            int count = index[now];

            if(!snake.get(now).isEmpty()){
                now = snake.get(now).get(0);
                index[now] = count;
            }

            for(int i=1;i<=6;i++){
                int next = now + i;
                if(next<100&&!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    index[next] = index[now]+1;
                }
            }
        }

    }

}
