package org.example.stackQ;

import java.util.Scanner;
import java.util.Stack;

/**
 * 블로그 볼거임 진짜 모르겠음
 *
 * 인덱스와 스택을 이용한 아주 고능한 문제풀이
 * */
public class Q17298 {
    static int N;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = scan.nextInt();
        }

        for(int i=0;i<N;i++){
           while (!stack.isEmpty() && (arr[stack.peek()] < arr[i])){
               arr[stack.pop()] = arr[i];
           }
           stack.push(i);
        }

        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
