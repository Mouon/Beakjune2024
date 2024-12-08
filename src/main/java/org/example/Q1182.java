package org.example;

import java.util.Scanner;

public class Q1182 {
    static int N, S, result = 0;
    static int[] arr;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        S = scan.nextInt();

        arr = new int[N];

        for (int i=0;i<N;i++){
            arr[i] =  scan.nextInt();
        }
        dfs(0, 0);

        if (S == 0) {
            result--;
        }
        System.out.println(result);

    }
    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                result++;
            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
