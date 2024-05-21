package org.example.implement;

import java.util.Scanner;

public class Q10995 {
    public static void main(String[] args) throws Exception {

        Scanner scan =new Scanner(System.in);
        int N = scan.nextInt();

        for (int i=1;i<=N;i++){
            if(i%2==1) {
                printStar(N);
            }else{
                System.out.print(" ");
                printStar(N);
            }
        }


    }

    static void printStar(int N){
        for (int j = 0; j < N; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
