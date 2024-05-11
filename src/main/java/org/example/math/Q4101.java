package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q4101 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[1000000];
        int i=0;
        while (true) {
            String input = br.readLine();
            if(input.equals("0 0")){
                break;
            }
            list[i] = input;
            i++;
        }
        for (int j=0;j<i;j++){
            String[] arr;
            arr=list[j].split(" ");
            System.out.println(Integer.parseInt(arr[0])>Integer.parseInt(arr[1])?"Yes":"No");
        }

    }
}
