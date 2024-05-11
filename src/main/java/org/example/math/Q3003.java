package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q3003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1= br.readLine();
        String[] list = str1.split(" ");

        int[] nums = new int[6];
        nums[0]=1-Integer.parseInt(list[0]);
        nums[1]=1-Integer.parseInt(list[1]);
        nums[2]=2-Integer.parseInt(list[2]);
        nums[3]=2-Integer.parseInt(list[3]);
        nums[4]=2-Integer.parseInt(list[4]);
        nums[5]=8-Integer.parseInt(list[5]);

        for (int i=0;i< list.length;i++) System.out.print(nums[i]+" ");
    }

}
