package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q10992 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i =0;i<N;i++) {

                for (int k = 0; k < N - 1 - i; k++) {
                    System.out.print(" ");
                }
                if(i==N-1){
                    for (int j = 0; j < i * 2; j++) {
                        System.out.print("*");
                    }
                }
                System.out.print("*");
                for (int j = 1; j < i * 2; j++) {

                    System.out.print(" ");
                }
                if(i!=0&&i!=N-1){
                System.out.print("*");
                }
                System.out.println();

        }

    }

}
