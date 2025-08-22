package org.example.implement;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2776 {
    static int T,N,M;
    static int[] arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());


        for (int i=0;i<T;i++){

            int N = Integer.parseInt(br.readLine());
            arr1= new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0;j<N;j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(binary(0, N-1, num)));
                bw.newLine();
            }

            bw.flush();


        }
        bw.close();

    }

    static int binary(int left, int right, int now){

        int ans = 0;
        while (left<=right){
            int mid = (left + right)/2;
            if(arr1[mid]>now){
                right = mid-1;
            }else if(arr1[mid]<now){
                left = mid+1;
            }else {
                ans = 1;
                break;
            }

        }

        return ans;

    }

}
