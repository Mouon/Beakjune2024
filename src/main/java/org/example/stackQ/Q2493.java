package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
    static int N;
    static int[] arr, ans;

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        ans = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = 0;
        for(int i=N;i>=1;i--){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                n = stack.pop();
                arr[n] = arr[i];
                ans[n] = i;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(ans[i]+" ");
        }

        System.out.println(sb);

    }
}
