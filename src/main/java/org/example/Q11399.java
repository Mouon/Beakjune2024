package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        int[] arr = new int[count];
        String str=scan.nextLine();
        String[] list = str.split(" ");

        int sum=0;
        int total=0;

        for(int i=0; i<count;i++){
            arr[i]= Integer.parseInt(list[i]);
        }
        Arrays.sort(arr);

        for(int i=0; i<count;i++){
            System.out.println(arr[i]);
            sum+=arr[i];
            total+=sum;
        }
        System.out.print(total);
    }




}
