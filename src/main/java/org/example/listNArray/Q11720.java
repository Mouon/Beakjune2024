package org.example.listNArray;

import java.util.Scanner;
/**
 * 아스키 성질 이용
 * */
public class Q11720 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int sum =0;
        scan.nextLine();
        String str = scan.nextLine();
        char chArr[] = str.toCharArray();
        for (int i =0;i<chArr.length;i++){
            sum+=chArr[i] - '0';
        }
        System.out.println(sum);
    }

}

/**
 *         Scanner scan = new Scanner(System.in);
 *         int N = scan.nextInt();
 *         int sum =0;
 *         scan.nextLine();
 *         String str = scan.nextLine();
 *         String strArr[] = str.split("");
 *         for (int i =0;i<strArr.length;i++){
 *                 sum+=Integer.parseInt(strArr[i]);
 *         }
 *         System.out.println(sum);
 *
 * */
