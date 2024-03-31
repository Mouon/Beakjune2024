package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1806 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum=0;
        int left=0;
        int right=0;
        int ans = Integer.MAX_VALUE;
        int len =0;

        while (right<=n){
            if(sum>=s){
                sum-=arr[left++];
                len=right-left+1;
                if(ans>len){
                    ans=len;
                }
            }else if (sum<s) {
                sum+=arr[right++];
            }
        }
        System.out.println((ans) == Integer.MAX_VALUE ? 0 : ans);

    }
}
