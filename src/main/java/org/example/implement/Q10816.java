package org.example.implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q10816 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }

        int K = scan.nextInt();
        int[] queries = new int[K];
        for (int i = 0; i < K; i++) {
            queries[i] = scan.nextInt();
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(int num : queries){
            sb.append(countMap.getOrDefault(num, 0)+" ");
        }



        System.out.println(sb);


    }
}
