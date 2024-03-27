package org.example;

import java.io.*;
import java.util.*;

public class Q1744 {

    static int N;
    static List<Integer> negative = new ArrayList<>();
    static List<Integer> positive = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0)
                positive.add(n);
            else
                negative.add(n);
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int sum = 0;
        int i = 0;
        while (i < positive.size()) {
            if (i + 1 < positive.size() && positive.get(i) != 1 && positive.get(i + 1) != 1){
                sum += positive.get(i) * positive.get(i+1);
                i+=2;
            }
            else{
                sum += positive.get(i);
                i++;
            }


        }

        i = 0;
        while (i < negative.size()) {
            if (i + 1 < negative.size() && negative.get(i) != 1 && negative.get(i + 1) != 1){
                sum += negative.get(i) * negative.get(i+1);
                i+=2;
            }
            else{
                sum += negative.get(i);
                i++;
            }
        }

        bw.write(sum + "\n");
        bw.close();
    }
}
