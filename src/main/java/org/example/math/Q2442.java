package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2442 {

    public static void main(String[] args) throws IOException {

        int l=0;
        int q=1;
        int N;
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();


        for(int i=0;i<N;i++){
            for(int k=0;k<l;k++){
                System.out.print(" ");
            }
            for(int j=0;j<N-l;j++){
                System.out.print("*");
            }
            for(int k=1;k<N-l;k++){
                System.out.print("*");
            }
            l++;
            if(i!=N-1) System.out.print("\n");
        }

    }
}
