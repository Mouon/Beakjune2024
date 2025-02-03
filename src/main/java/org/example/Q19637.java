package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 이분탐색의 좋은 문제 같다.
 * */

public class Q19637 {

    static int N ;
    static int M ;
    static String[] keys, values ;
    static int left =0;
    static int right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        keys = new String[N];
        values = new String[N];

        right = N-1;



        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            keys[i] = st.nextToken();
            values[i] = st.nextToken();
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(ifFun(num,left,right)).append('\n');
        }
        System.out.println(sb);
    }

    public static String ifFun(int num, int left, int right){
        int ans = 0;
        int mid;
        
        while(left <= right) {
            mid = (left + right) / 2;
            if(num<=Integer.parseInt(values[mid])) {
                ans = mid;  
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return keys[ans];
    }
    
    
}

