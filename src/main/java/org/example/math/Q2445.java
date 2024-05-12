package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2445 {

    public static void main(String[] args) throws IOException {

        int l = 0;
        int t = 0;

        int N;
        int u=1;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        for(int i=0;i<N-1;i++){
            for(int k=0;k<l+1;k++){
                System.out.print("*");
            }

            for(int k=2;k<(N-l)*2;k++){
                System.out.print(" ");
            }

            for (int j = 0; j < u; j++) {
                System.out.print("*");
            }
            u++;
            l++;
            t++;
            System.out.print("\n");
        }
        for (int j = 0; j < N*2; j++) {
            System.out.print("*");
        }
        System.out.print("\n");

        int q = 1;
        l = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - l-1; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < q*2; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < N - l-1; j++) {
                System.out.print("*");
            }
            l++;
            q++;

            if (i != N - 1) System.out.print("\n");
        }


    }

}
