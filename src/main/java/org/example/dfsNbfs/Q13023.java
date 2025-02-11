package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q13023 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
    static boolean[] visited;
    static boolean found;
    static ArrayList<Integer> depths = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N];
        for(int i=0;i<N;i++){
            friends.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int first = scan.nextInt();
            int after = scan.nextInt();

            friends.get(first).add(after);
            friends.get(after).add(first);
        }


        for (int i=0;i<N;i++){
            DFS(i,0);
            if(found) break;
        }

        System.out.println(found ? 1 : 0);


    }

    static void DFS(int node, int depth){

        if(depth == 4) {  // 깊이가 4면 노드 5개가 연결된 것
            found = true;
            return;
        }

        if(depth==5){
            return;
        }
        visited[node] = true;

        for(int friend : friends.get(node)){
            if(!visited[friend]){
                DFS(friend,depth+1);
            }
        }
        visited[node] = false;
    }
}
