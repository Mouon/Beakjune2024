package org.example.implement;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q2566 {

    public static void main(String[] args) throws IOException {

        Scanner scan =new Scanner(System.in);
        int[][] index = new int[9][9];
        for(int i=0;i<9;i++){
            String str = scan.nextLine();
            String[] num = str.split(" ");
            for(int j = 0; j < num.length; j++){
                index[i][j] = Integer.parseInt(num[j]);
            }
        }

        int max=findMax(index);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max==index[i][j]){
                    int x=i+1;
                    int y=j+1;
                    System.out.println(index[i][j]);
                    System.out.print(x+ " "+y);
                    return;
                }
            }
        }

    }


    public static int findMax(int[][] arrays){
        return Arrays.stream(arrays)
                .flatMapToInt(Arrays::stream)
                .max().orElseThrow();
    }

}
