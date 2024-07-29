package org.example.listNArray;

import java.util.Scanner;

public class Q11720 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int sum =0;
        scan.nextLine();
        String str = scan.nextLine();
        String strArr[] = str.split("");
        for (int i =0;i<strArr.length;i++){
                sum+=Integer.parseInt(strArr[i]);
        }
        System.out.println(sum);


    }

}
