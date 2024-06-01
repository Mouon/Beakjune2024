package org.example.implement;

import java.util.Scanner;

public class Q10103 {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[][] round = new int[N][2];

        int chang = 100;
        int sang =100;

        for(int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] arr =str.split(" ");
            int ch =Integer.parseInt(arr[0]);
            int sh =Integer.parseInt(arr[1]);
            if(ch<sh){
                chang-=sh;
            } else if (ch>sh) {
                sang-=ch;
            }
        }

        System.out.println(chang);
        System.out.println(sang);



    }

}
