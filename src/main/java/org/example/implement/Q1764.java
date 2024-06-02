package org.example.implement;

import java.io.IOException;
import java.util.Scanner;

public class Q1764 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = N;
        int count =0;
        while (true){

            int i = N/10;
            int j =N%10;
            N=j*10+((i+j)%10);
            count++;
//            System.out.println(N);
            if(N==K){
                break;
            }

        }
        
        System.out.println(count);
    }
}
