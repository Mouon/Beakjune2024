package org.example.implement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11650 {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String[][] XY = new String[N][2];


        for (int i = 0; i < N; i++) {
            String input = scan.nextLine();
            String[] temp = input.split(" ");
            XY[i][0] = temp[0];
            XY[i][1] = temp[1];
        }

        Arrays.sort(XY, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int xCompare = Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
                if(xCompare==0){
                    /** 같으면 Y 비교 */
                    return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
                }
                return xCompare;
            }
        });


        for (int i = 0; i < N; i++) {
            System.out.println( XY[i][0]+" "+ XY[i][1]);
        }
    }


}
