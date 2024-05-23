package org.example.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q10867 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = (Integer.parseInt(st.nextToken()));
        }


        Arrays.sort(numbers);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(!list.contains(numbers[i])){
                list.add(numbers[i]);
            }
        }

        for (int j : list) {
            System.out.print(j+" ");
        }

    }
}
