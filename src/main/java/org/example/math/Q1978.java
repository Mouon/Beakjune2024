package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1978 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int count =0;
        int primeCount=0;
        String num = scan.nextLine();
        String[] list = new String[N];
        list = num.split(" ");

        for(int j=0;j<N;j++){
            count=0;
            for(int i=1;i<=Integer.parseInt(list[j]);i++){
                if(Integer.parseInt(list[j])%i==0){
                    count++;
                }
            }
            if(count==2) primeCount++;
        }

        System.out.println(primeCount);

    }
}
