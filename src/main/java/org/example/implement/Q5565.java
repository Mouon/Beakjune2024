package org.example.implement;

import java.io.IOException;
import java.util.Scanner;

public class Q5565 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] arr = new int[10];
        int sum=0;
        for(int i=0;i<9;i++){
            arr[i]=scan.nextInt();
            sum+=arr[i];
        }
        System.out.println(total-sum);


    }
}
