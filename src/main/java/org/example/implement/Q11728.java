package org.example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q11728 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringTokenizer arr1 = new StringTokenizer(br.readLine());
        StringTokenizer arr2 = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(arr1.nextToken()));
        }
        for(int i=0;i<K;i++){
            arr.add(Integer.parseInt(arr2.nextToken()));
        }

        Collections.sort(arr);

        for (int num : arr) {
            sb.append(num+" ");
        }

        System.out.println(sb);

    }
}
