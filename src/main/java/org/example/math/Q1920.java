package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String str1= br.readLine();
        String[] list = str1.split(" ");

        Set<String> set = new HashSet<>();
        for(String num : list) {
            set.add(num);
        }

        count = Integer.parseInt(br.readLine());
        str1= br.readLine();
        String[] list2 = str1.split(" ");
        br.close();

        for(int j=0;j<count;j++){
            System.out.println(set.contains(list2[j]) ? "1" : "0");
        }
    }

}
