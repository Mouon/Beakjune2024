package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Toss2022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String arr[] = input.split("");
        int sol=-1;
        for (int i=0;i< arr.length-2;i++){
            if(Integer.parseInt(arr[i])==Integer.parseInt(arr[i+1])&&Integer.parseInt(arr[i+1])==Integer.parseInt(arr[i+2])){
                sol=Math.max(Integer.parseInt(input.substring(i,i+3)),sol);
            }
        }

        System.out.print(sol);
    }

}

/**  @초기풀이
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         String input = br.readLine();
 *         String arr[] = input.split("");
 *         int sol=-1;
 *         for (int i=0;i< arr.length-2;i++){
 *
 *             if(Integer.parseInt(arr[i])==Integer.parseInt(arr[i+1])&&Integer.parseInt(arr[i+1])==
 *                     Integer.parseInt(arr[i+2])){
 *                 sol=Integer.parseInt(arr[i]);
 *             }
 *         }
 *
 *         if(sol==-1){
 *             System.out.print(sol);
 *             return;
 *         }
 *         System.out.print(sol);
 *         System.out.print(sol);
 *         System.out.print(sol);
 *
 *
 * */
