package org.example.implement;

import java.math.BigInteger;
import java.util.Scanner;

public class Q10824 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] numbers = str.split(" ");

        long A= Long.parseLong(numbers[0]+numbers[1]);
        long B= Long.parseLong(numbers[2]+numbers[3]);

        System.out.println(A+B);


    }
}
