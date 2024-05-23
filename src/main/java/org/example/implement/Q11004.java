package org.example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q11004 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers=new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = (Integer.parseInt(st.nextToken()));
        }


        Arrays.sort(numbers);

        System.out.println(numbers[K-1]);

    }
}
