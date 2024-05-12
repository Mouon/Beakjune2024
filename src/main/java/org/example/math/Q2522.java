package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2522 {

    public static void main(String[] args) throws IOException {



        int l = 0;
        int q = 1;
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - l - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < q; k++) {
                System.out.print("*");
            }
            l++;
            q++;
            System.out.print("\n");
        }

        l = 1;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < q-l; k++) {
                System.out.print("*");
            }


            l++;
            if (i != N - 1) System.out.print("\n");
        }
    }
}