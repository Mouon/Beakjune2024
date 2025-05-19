package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 블로그 참고
public class Q1931 {
    static int N;
    static int[][] meet;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        meet = new int[N][2];

        for(int i=0;i<N;i++){
            meet[i][0] = scan.nextInt();
            meet[i][1] = scan.nextInt();
        }

        Arrays.sort(meet, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        int count = 0;
        int prev = 0;

        for(int i=0; i<N; i++){
            if(prev<=meet[i][0]){
                prev = meet[i][1];
                count++;
            }
        }

        System.out.print(count);
    }
}
