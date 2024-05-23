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

//        Arrays.sort(XY);

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

/**
 *Arrays.sort 메소드를 사용할 때, 이차원 배열의 각 행이 1차원 배열로 간주되어 Comparator의 compare 메소드에서 비교
 *
 * 이차원 배열의 정렬 과정
 * 이차원 배열의 각 행을 1차원 배열로 간주:
 *
 * 이차원 배열 XY의 각 요소는 1차원 배열입니다. 예를 들어, XY 배열이 {"3", "4"}, {"2", "3"}, {"3", "2"}로 구성된 경우, 각 행은 String[] 타입의 1차원 배열입니다.
 * Arrays.sort와 Comparator 사용:
 *
 * Arrays.sort 메소드는 이차원 배열 XY의 각 행을 정렬할 때, Comparator를 사용하여 두 1차원 배열을 비교합니다.
 *
 *
 * */