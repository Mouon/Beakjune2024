package org.example.implement;

import java.util.Scanner;

public class Q11721 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr=str.split("");

        for(int i=1;i<arr.length+1;i++){
            System.out.print(arr[i-1]);
            if(i%10==0){
                System.out.println();
            }
        }

    }
}
