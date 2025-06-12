package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 프림 알고리즘이래
public class Q1647 {

    static int N,M;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        visited = new boolean[N + 1];
        System.out.println(prim());

    }

    public static int prim() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 0));
        int dist = 0;
        int max = 0;

        while (!q.isEmpty()){
            Node current = q.poll();

            if(!visited[current.n]){
                visited[current.n] = true;
            }else{
                continue;
            }

            max = Math.max(max, current.cost);
            dist += current.cost;

            for(int i = 0; i<list[current.n].size();i++){
                Node next = list[current.n].get(i);
                if(!visited[next.n]){
                    q.offer(new Node(next.n, next.cost));
                }
            }
        }
        return dist - max;
    }

    public static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        // 우선 순위 큐의 기준
        @Override
        public int compareTo(Node n1) {
            return this.cost - n1.cost;
        }
    }
}
