package org.example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int trees[] = new int[N];
        int min=0;

        long sum=0;
        String str = br.readLine();
        String strA[] = str.split(" ");
        for (int i=0;i<N;i++){
            trees[i]=Integer.parseInt(strA[i]);
        }

        Arrays.sort(trees);
        int max=trees[N-1];

        while (min<max) {
            int mid = (max+min)/2;
            sum=0;
            for (int i = 0; i < N; i++) {
                if(trees[i]-mid>0) {
                    sum+=trees[i]-mid;
                }
            }
            if(sum<M){
                max = mid;
            }else {
                min = mid+1;
            }

        }
        System.out.println(min-1);
    }
}
