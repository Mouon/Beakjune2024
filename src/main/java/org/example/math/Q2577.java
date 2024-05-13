package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Q2577 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int result =1;

        int[] count = new int[10];

        for(int j =0;j<10;j++){
            count[j]=0;
        }


        for(int i=0;i<3;i++){
            result*=scan.nextInt();
        }
        int[] digits = Stream.of(String.valueOf(result).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=0;i<=9;i++){

            for(int j : digits){
                if(i==j){
                    count[i]++;
                }
            }

        }


        for(int i=0;i<=9;i++){

            System.out.println(count[i]);

        }

    }
}
