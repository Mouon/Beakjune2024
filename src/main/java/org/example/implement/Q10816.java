package org.example.implement;

import java.util.Scanner;

public class Q10816 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        String[] strNum1 = str.split(" ");
        int K = scan.nextInt();
        scan.nextLine();
        int[] num = new int[K];
        String str2 = scan.nextLine();
        String[] strNum2 = str2.split(" ");

        for(String s : strNum1){
            for(int i=0;i<K;i++){
               if(strNum2[i].equals(s)){
                   num[i]+=1;
               }
            }
        }

//        for(int i=0;i<strNum1.length;i++){
//            System.out.print(" "+strNum1[i]+" ");
//        }
//
//        System.out.println();
//
//        for(int i=0;i<K;i++){
//            System.out.print(strNum2[i]+" ");
//        }
//        System.out.println();

        for(int i=0;i<K;i++){
            sb.append(num[i]+" ");
        }


        System.out.println(sb);


    }
}
