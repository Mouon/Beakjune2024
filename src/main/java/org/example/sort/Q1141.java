package org.example.sort;

import java.util.*;

public class Q1141 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine(); // 개행 문자 처리

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextLine();
        }

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int result = 0;

        boolean[] removed = new boolean[N];

        for (int i = N - 1; i >= 0; i--) {
            if (removed[i]) continue;
            result++;

            for (int j = 0; j < i; j++) {
                if (removed[j]) continue;

                if (arr[i].startsWith(arr[j])) {
                    removed[j] = true;
                }
            }
        }

        System.out.println(result);
    }
}

