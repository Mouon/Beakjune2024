package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2644 {
    static int N,M,person1,person2,ans=-1;
    static ArrayList<ArrayList<Integer>> chon = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        person1 = scan.nextInt();
        person2 = scan.nextInt();

        M = scan.nextInt();

        for(int i=0;i<=N;i++){
            chon.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            int parent = scan.nextInt();
            int child = scan.nextInt();

            chon.get(parent).add(child);
            chon.get(child).add(parent);
        }

        DFS(person2,0);

        System.out.println(ans);


    }

    static void DFS(int node, int depth){

        visited[node] = true;
        if(node==person1){
            ans = depth;
            return;
        }

        for(int now : chon.get(node)){
            if(!visited[now]){
                DFS(now,depth+1);
            }
        }
    }
}
