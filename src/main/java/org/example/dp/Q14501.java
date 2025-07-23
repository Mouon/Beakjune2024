package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q14501 {
    static int N;
    static int[] T,P, ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        T = new int[N+1];
        P = new int[N+1];
        ans = new int[N+2];

        for(int i=1;i<=N;i++){
            T[i] = scan.nextInt();
            P[i] = scan.nextInt();
        }

        for(int i=N;i>=1;i--){
            if(i+T[i] <= N+1){
               ans[i] = Math.max(P[i] + ans[i+T[i]], ans[i+1]);
            }else{
                ans[i] = ans[i+1];
            }
        }

        int max = Arrays.stream(ans).max().getAsInt();

        System.out.println(max);

    }
}
