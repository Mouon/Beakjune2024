package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1271 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] list = str.split(" ");
        BigInteger num1 = new BigInteger(list[0]);
        BigInteger num2 = new BigInteger(list[1]);
        System.out.println(num1.divide(num2));
        System.out.println(num1.remainder(num2));
    }
}
