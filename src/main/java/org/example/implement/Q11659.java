package org.example.implement;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 구간합 구하기 4 */
public class Q11659 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        int[] ans = new int[N];
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(str.nextToken());
        }
        ans[0]=num[0];

        for(int i=1;i<N;i++){
            ans[i] += ans[i-1]+num[i];
        }

//
//        for(int i=0;i<N;i++){
//            System.out.println(ans[i]);
//        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken())-1;
            int E = Integer.parseInt(st.nextToken())-1;
            System.out.println(ans[E]-ans[S]+num[S]);
        }



    }
}
