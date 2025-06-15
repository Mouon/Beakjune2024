package org.example.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2675 {
    static int N;
    static int[] counts;
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        counts = new int[N];
        str = new String[N];


        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            counts[i] = Integer.parseInt(st.nextToken());
            str[i] = st.nextToken();
        }

        for (int i = 0; i<N; i++){
            String[] chars = str[i].split("");
            for (int j = 0; j<str[i].length(); j++){
                for (int k = 0; k<counts[i]; k++){
                    System.out.print(chars[j]);
                }
            }
            System.out.println();
        }


    }
}
