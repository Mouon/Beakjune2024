package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2444 {

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
            for (int k = 1; k < q; k++) {
                System.out.print("*");
            }
            l++;
            q++;

            if (i != N - 1) System.out.print("\n");
        }
        l = 0;
        System.out.print("\n");
        for(int i=0;i<N;i++){
            for(int k=0;k<l+1;k++){
                System.out.print(" ");
            }
            for(int j=1;j<N-l;j++){
                System.out.print("*");
            }
            for(int k=2;k<N-l;k++){
                System.out.print("*");
            }
            l++;
            if(i!=N-1) System.out.print("\n");
        }


    }


}
