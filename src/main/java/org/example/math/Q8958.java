package org.example.math;

import java.util.Scanner;
import java.util.stream.Stream;

public class Q8958 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();
        String[] ox = new String[N];

        int streak=1;
        int[] score=new int[N];
        for(int i=0;i<N;i++){
            ox[i]= scan.nextLine();
            score[i]=0;
        }

        for(int i=0;i<N;i++){
            String[] temp = ox[i].split("");
            for(String k : temp){
                if(k.equals("O")||k.equals("o")){
                    score[i]+=streak*1;
                    streak++;
                }else{
                    streak=1;
                }
            }
            streak=1;
        }

        for(int i: score){
            System.out.println(i);
        }



    }

}
