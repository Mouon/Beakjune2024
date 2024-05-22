package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q13241 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");

        long num1 = Long.parseLong(list[0]);
        long num2 = Long.parseLong(list[1]);

        long gcd = gcd(num1, num2);
        long lcm = (num1 * num2) / gcd;

        System.out.println(lcm);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
