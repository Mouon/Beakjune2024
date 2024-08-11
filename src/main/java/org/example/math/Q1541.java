package org.example.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1541 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split("-");
        ArrayList<Long> list = new ArrayList<>();

        for (int i=0;i< arr.length;i++){
            String[] temp = arr[i].split("\\+");
            long tempSum = 0;
            for (String s : temp) {
                tempSum += Long.parseLong(s);
            }
            list.add(tempSum);
        }

        long sum= list.get(0);
        for (int i=1;i<list.size();i++){
            sum-= list.get(i);
        }
        System.out.println(sum);

    }
}
