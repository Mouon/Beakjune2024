package org.example.stackQ;

import java.util.Scanner;
import java.util.Stack;

/**
 * 블로그 볼거임 진짜 모르겠음
 * */
public class Q17298 {
    static int N;
    static int[] arr , ans;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        arr = new int[N];
        ans = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = scan.nextInt();
            ans[i] = -1;
        }

        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(arr[i] < arr[j]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        for (int num : ans){
            System.out.print(num + " ");
        }

    }
}
