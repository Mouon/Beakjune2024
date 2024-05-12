package org.example.math;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q2562 {

    public static void main(String[] args) throws IOException {

        int[] num= new int[9];
        int max =0;
        Scanner scan = new Scanner(System.in);

        for(int i=0;i<9;i++){
            num[i]=scan.nextInt();
        }


        for (int i : num) {
            max = Math.max(max, i);
        }

        System.out.println(max);

        List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());

        System.out.println(list.indexOf(max)+1);

    }

}
