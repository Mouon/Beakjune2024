package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q9466 {
    static int N,T;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        T= scan.nextInt();

        for(int j=0;j<T;j++){
            N = scan.nextInt();

            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            result = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                arr[i] = scan.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    search(i, new ArrayList<>());
                }
            }

            Collections.sort(result);
            System.out.println(N-result.size());
        }

    }

    static void search(int node, List<Integer> path){
        if (visited[node]) {
            if (path.contains(node)) {
                int idx = path.indexOf(node);
                result.addAll(path.subList(idx, path.size()));
            }
            return;
        }

        visited[node] = true;
        path.add(node);
        search(arr[node], path);
    }
}
