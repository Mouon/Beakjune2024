package org.example.implement;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 구간합 구하기 4 */
public class Q11659 {

    public static void main(String[] args) throws Exception {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(buf.readLine());
        int N=Integer.parseInt(stringTokenizer.nextToken());
        int M=Integer.parseInt(stringTokenizer.nextToken());
        long[] sumArr = new long[N+1];
        long[] ans = new long[M];
        stringTokenizer = new StringTokenizer(buf.readLine());
        for(int i=1;i<N+1;i++){
            sumArr[i]=sumArr[i-1]+Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(buf.readLine());
            int st=Integer.parseInt(stringTokenizer.nextToken());
            int ed=Integer.parseInt(stringTokenizer.nextToken());
            ans[i]=sumArr[ed]-sumArr[st-1];
        }
        for(int i=0;i<M;i++){
            System.out.println(ans[i]);
        }

    }
}
