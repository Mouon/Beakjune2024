package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20040 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                result = i;// 차례
                break;
            }
            union(a, b);
        }

        System.out.println(result);
    }

    private static void union(int a, int b){
        int rootA = parents[a];
        int rootB = parents[b];

        parents[rootB] = rootA;
    }

    private static int find(int n) {
        if(parents[n] == n){
            return n;
        }
        return parents[n] = find(parents[n]);
    }
}
