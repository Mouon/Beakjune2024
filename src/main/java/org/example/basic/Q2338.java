package org.example.basic;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Q2338 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BigInteger N = new BigInteger(scan.next());
        BigInteger K = new BigInteger(scan.next());

        System.out.println(N.add(K));
        System.out.println(N.subtract(K));
        System.out.println(N.multiply(K));
    }
}
