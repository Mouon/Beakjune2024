package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 연결요소 문제
 * */
public class ProNet {
    static class Solution {
        static boolean[] visited;
        static ArrayList<ArrayList<Integer>> com = new ArrayList<>();
        public int solution(int n, int[][] computers) {
            int answer = 0;

            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                com.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && computers[i][j] == 1) {
                        com.get(i).add(j);
                        com.get(j).add(i);
                    }
                }
            }

            for (int i=0;i<n;i++){
                if(!visited[i]){
                    bfs(i);
                    answer++;
                }
            }


            return answer;
        }

        public static void bfs(int start){
            Queue<Integer> queue = new LinkedList();
            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()){
                int now = queue.poll();
                    for(int next : com.get(now)){
                        if(!visited[next]){
                            queue.add(next);
                            visited[next] = true;
                        }
                    }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        int[][] computers1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result1 = sol.solution(n1, computers1);
        System.out.println("Test Case 1 Result: " + result1); // Expected: 2

        int n2 = 3;
        int[][] computers2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int result2 = sol.solution(n2, computers2);
        System.out.println("Test Case 2 Result: " + result2);
    }
}
