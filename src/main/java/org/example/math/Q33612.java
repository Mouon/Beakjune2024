package org.example.math;

import java.util.Scanner;

public class Q33612 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt()-1;

        int y = 2024;
        int m = 8;

        int temp = 7*N+m;

        int y2 = temp/12;
        int m2 = temp%12;


        if(temp%12==0){
            y = y+y2-1;
            m = 12;
            System.out.println(y+" "+m);
        }else {
            y = y+y2;
            m = m2;
            System.out.println(y+" "+m);
        }


    }
}
