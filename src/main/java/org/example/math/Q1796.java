package org.example.math;

import java.io.*;

public class Q1796 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = bufferedReader.readLine();
        bufferedReader.close();

        String isMultipleOfThree = "";
        long result = Integer.MAX_VALUE;
        int digitCount = 0;

        if (inputNumber.length() != 1) {
            while (result / 10 != 0) {
                result = computePartialSum(inputNumber, 0);
                inputNumber = Long.toString(result);
                digitCount += 1;
            }
        } else {
            result = Long.parseLong(inputNumber);
        }

        isMultipleOfThree = result % 3 == 0 ? "YES" : "NO";
        System.out.println(digitCount);
        System.out.println(isMultipleOfThree);
    }

    private static long computePartialSum(String number, int index) {
        if (index == number.length()) {
            return 0;
        }
        return (number.charAt(index) - '0') + computePartialSum(number, index + 1);
    }
}
