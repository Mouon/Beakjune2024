package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3052 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int temp=-1;
        int count=0;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<10;i++){
            temp=scan.nextInt();
            temp%=42;
            if(!arr.contains(temp)) {
                arr.add(temp);
                count++;
            }

        }


        System.out.println(count);





    }
}