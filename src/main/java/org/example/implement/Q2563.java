package org.example.implement;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Q2563 {

    public static void main(String[] args) throws Exception {

        int x,y;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[][] sq = new int[N][2];
        int[][] area =new int[100][100];
        for (int i = 0; i < area.length; i++) {
            Arrays.fill(area[i], 1);
        }        int minus=0;
        for(int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] xy=str.split(" ");

            for(int j=Integer.parseInt(xy[0]);j<Integer.parseInt(xy[0])+10;j++){
                for(int k=Integer.parseInt(xy[1]);k<Integer.parseInt(xy[1])+10;k++){
                    if(area[j][k]<=0){
                        area[j][k]--;
                    }else if(area[j][k]==1){
                        area[j][k]=0;
                    }
                }
            }

        }
        for(int j=0;j<100;j++){
            for(int k=0;k<100;k++){
                if(area[j][k]<0){
                    minus+=area[j][k];
                }
            }
        }
        System.out.println(100*N+minus);


        }



    }


