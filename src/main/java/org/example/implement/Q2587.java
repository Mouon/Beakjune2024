package org.example.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2587 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int[] arr = new int[5];
        ArrayList<Integer> real = new ArrayList<>();

        int sum=0;
        for(int i=0;i<5;i++){
            arr[i]=scan.nextInt();
            sum+=arr[i];
        }

        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);

    }
}
