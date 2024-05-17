package org.example.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2750 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[] num = new long[N];
        for(int i=0;i<N;i++){
            num[i]=scan.nextInt();
        }
        Arrays.sort(num);
        for(int i=0;i<N;i++){
            System.out.println(num[i]);
        }

    }
}
