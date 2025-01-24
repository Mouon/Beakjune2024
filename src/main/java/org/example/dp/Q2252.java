package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        /**
         * 진입 차수
         */
        indegree = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int former = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            arr[former].add(after);
            indegree[after]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp+" ");
            for(int num : arr[temp]){
                indegree[num]--;
                if(indegree[num]==0){
                    queue.add(num);
                }
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}
