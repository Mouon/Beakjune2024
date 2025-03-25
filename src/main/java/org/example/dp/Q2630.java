package org.example.dp;

import java.util.*;

public class Q2630 {
    static int N,w=0,b=0;
    static int[][] arr ;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = scan.nextInt();
            }
        }

        search(0,0,N);

        System.out.println(w);
        System.out.println(b);

    }

    static void search(int startX,int startY,int size){

        if(colorCheck(startX,startY,size)){
            if(arr[startX][startY]==0){
                w++;
            }else {
                b++;
            }
            return;
        }

        search(startX,startY,size/2);
        search(startX+size/2,startY,size/2);
        search(startX,startY+size/2,size/2);
        search(startX+size/2,startY+size/2,size/2);


    }

    public static boolean colorCheck(int row, int col, int size) {

        int color = arr[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
