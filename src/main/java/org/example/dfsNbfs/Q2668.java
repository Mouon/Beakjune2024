package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2668 {
    static int N,C,M=0;
    static int[] arr;
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                search(i, new ArrayList<>());
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
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
