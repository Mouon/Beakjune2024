package org.example.math;

import java.util.Scanner;

// 왜 틀리누
public class Q2166 {
    static int N ;
    static int[][] index;
    public static void main(String[] args) {
        long a=0,b=0;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        index = new int[N][2];

        for (int i=0;i<N;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            index[i][0] = x;
            index[i][1] = y;
        }

        for (int i = 0; i < N-1; i++) {
            a += (long) index[i][0] * index[i + 1][1];
            b += (long) index[i][1] * index[i + 1][0];
        }

        double area = Math.abs(a - b) / 2.0;
        System.out.printf("%.1f", area);

    }
}
