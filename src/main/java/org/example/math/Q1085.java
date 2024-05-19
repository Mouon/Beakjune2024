package org.example.math;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1085 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        String square = scan.nextLine();
        String[] str = square.split(" ");

        int[] arr=new int[4];
        arr[0]=Integer.parseInt(str[0]);
        arr[1]=Integer.parseInt(str[1]);

        arr[2]=Math.abs(Integer.parseInt(str[0])-Integer.parseInt(str[2]));
        arr[3]=Math.abs(Integer.parseInt(str[1])-Integer.parseInt(str[3]));

        Arrays.sort(arr);

        System.out.println(arr[0]);

    }
}
