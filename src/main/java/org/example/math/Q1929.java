package org.example.math;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1929 {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");
        prime = new boolean[Integer.parseInt(list[1]) + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i*i <= Integer.parseInt(list[1]); i++) {
            if (prime[i]) {
                for (int j = i*i; j <= Integer.parseInt(list[1]); j+=i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = Integer.parseInt(list[0]); i <= Integer.parseInt(list[1]); i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }

    }
}
