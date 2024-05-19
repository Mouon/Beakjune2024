package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2501 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strNum = str.split(" ");
        int j=1;

        int N = Integer.parseInt(strNum[0]);
        int K = Integer.parseInt(strNum[1]);
        int[] M = new int[N+1];


        for(int i=1;i<=N;i++){
            if(N%i==0){
                M[j++]=i;
            }
        }

        System.out.println(M[K]);


    }
}
