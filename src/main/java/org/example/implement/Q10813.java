package org.example.implement;

import java.util.HashMap;
import java.util.Scanner;

public class Q10813 {

    public static void main(String[] args) throws Exception {

        HashMap<Integer,Integer> alpha = new HashMap<Integer,Integer>();

        Scanner scan =new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr =str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        for(int i=1;i<=N;i++){
            alpha.put(i,i);
        }
//        for(int i=1;i<=N;i++){
//            System.out.print(alpha.get(i)+" ");
//        }
//        System.out.println();

        for(int i=0;i<M;i++){

            str = scan.nextLine();
            String[] mix =str.split(" ");
            int F = Integer.parseInt(mix[0]);
            int S = Integer.parseInt(mix[1]);
            int temp = alpha.get(F);
            alpha.put(F, alpha.get(S));
            alpha.put(S, temp);
//            for(int j=1;j<=N;j++){
//                System.out.print(alpha.get(j)+" ");
//            }
//            System.out.println();

        }

        for(int i=1;i<=N;i++){
            System.out.print(alpha.get(i)+" ");
        }

    }

}
