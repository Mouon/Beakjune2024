package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2010 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int total =0;

        for(int i=0;i<count;i++){

            total+= scan.nextInt();

        }

        System.out.println(total-(count-1));



    }
}
