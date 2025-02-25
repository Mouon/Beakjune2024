package org.example.sort;

import java.util.Scanner;

public class Q1654 {
    static int K, N;
    static int[] lan;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        K = scan.nextInt();
        N = scan.nextInt();

        lan = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = scan.nextInt();
            if (lan[i] > max) {
                max = lan[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += lan[i] / mid;
            }

            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
