package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
    static int F, S, G, U, D;
    static int[] dx;
    static int[] building;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        F = scan.nextInt();
        S = scan.nextInt();
        G = scan.nextInt();
        U = scan.nextInt();
        D = scan.nextInt();

        dx = new int[]{U,-D};
        building = new int[F+1];
        visited = new boolean[F+1];

        bfs(S);

        if(!visited[G]){
            System.out.println("use the stairs");
        }else {
            System.out.println(building[G]);

        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<2;i++){
                int next = now + dx[i];
                if(next<F&&next>0&&!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    building[next] = building[now] + 1;
                }else if(next==G&&!visited[next]){
                    visited[next] = true;
                    building[next] = building[now] + 1;
                }
            }
        }

    }

}
