package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2441 {

    public static void main(String[] args) throws IOException {

        int l=0;
        int N;
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();

        for(int i=0;i<N;i++){
            for(int j=0;j<l;j++){
                System.out.print(" ");
            }
            for(int k=0;k<N-l;k++){
                System.out.print("*");
            }
            System.out.println();
            l++;
        }

    }

}
