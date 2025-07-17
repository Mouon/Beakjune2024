package org.example.dp;

import java.util.ArrayList;
import java.util.Scanner;

// 진짜 모르겠네
// 육각수 한 변이 n인 육각수의 점의 개수: n(2n - 1)
public class Q1229 {
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int[] d = {0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 2};
        int[] dp = new int[N + 1];

        if (N < 13) {
            System.out.println(d[N]);
        } else {
            for (int i = 0; i < d.length; i++) {
                dp[i] = d[i];
            }
            // 육각수들을 뽑아냄
            ArrayList<Integer> list = get(N);
            for (int i = 13; i < N + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int a : list) {
                    if (a <= i) {
                        min = Math.min(min, dp[i - a]);
                    }
                }
                dp[i] = min + 1;
            }
            System.out.println(dp[N]);
        }
    }

    // 6각 수를 더뽑아
    public static ArrayList<Integer> get(int limit) {
        int n = 1;
        int current = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (current <= limit) {
            current = n * (2 * n - 1);
            list.add(current);
            n += 1;
        }
        return list;
    }

}
