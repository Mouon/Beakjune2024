package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q10991 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i =0;i<N;i++){
            for(int k=0;k<N-1-i;k++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){

                System.out.print("* ");
            }
            System.out.println();
        }


    }

}
