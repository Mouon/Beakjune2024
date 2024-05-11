package org.example.basic;

import java.io.IOException;
import java.util.Scanner;

public class Q5522 {
    public static void main(String[] args) throws IOException {

        int sum=0;
        Scanner scan =new Scanner(System.in);
        for(int i=0;i<5;i++){
            sum+=scan.nextInt();
        }
        System.out.println(sum);

    }
}
