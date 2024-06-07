package org.example.implement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11651 {
    public static void main(String[] args) throws Exception {


        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[][] cord = new int[N][2];/** 멍청하게 N 이라는 변수로 둬야하는데 5라고둬서 틀림 */

        for(int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            cord[i][0]=Integer.parseInt(arr[0]);
            cord[i][1]=Integer.parseInt(arr[1]);
        }

        Arrays.sort(cord, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                int yCompare = Integer.compare(o1[1],o2[1]);
                if(yCompare==0){
                    return Integer.compare(o1[0],o2[0]);
                }
                return yCompare;
            }
        });

        for(int i=0;i<N;i++){
            System.out.print(cord[i][0]+" ");
            System.out.println(cord[i][1]);

        }

    }
}
