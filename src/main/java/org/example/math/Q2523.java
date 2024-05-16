package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2523 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i=0;i<N;i++){
            for (int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=1;i<N;i++){
            for (int j=N;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
