package org.example.dp;

import java.util.Scanner;

public class Q9465 {
    static int T,n;
    static int[][] sticker;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();


        for(int i=0; i<T; i++){
            n = scan.nextInt();
            sticker = new int[2][n+1];
            for(int j=0;j<2;j++){
                for(int k=1;k<=n;k++){
                    sticker[j][k] = scan.nextInt();
                }
            }
            recur();
            System.out.println(Math.max(sticker[0][n],sticker[1][n]));
        }

    }

    static void recur(){
        for(int i=2;i<=n;i++){
            sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
            sticker[1][i] += Math.max(sticker[0][i-1],sticker[0][i-2]);
        }
    }
}
