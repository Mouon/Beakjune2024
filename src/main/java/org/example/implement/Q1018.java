package org.example.implement;

import java.util.Scanner;

public class Q1018 {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = scan.next();

            for (int j = 0; j < M; j++) {
                if(str.charAt(j)=='W'){
                    arr[i][j]=true;
                } else {
                    arr[i][j]=false;
                }
            }
        }

        /** 움직이는거 경우의 수 */
        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }


    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean board = arr[x][y];

        for(int i=x;i<end_x;i++){
            for(int j=y;j<end_y;j++){

                if(arr[i][j] != board){
                    count++;
                }
                board=(!board);/** 다음칸은 색이 달라야해 */
            }
            board=(!board);/** 다음칸줄은 위에 줄과 색이 달라야해 */

        }

        count=Math.min(count,64-count);

        min=Math.min(count,min);

    }


}
