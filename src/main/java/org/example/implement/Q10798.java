package org.example.implement;

import java.util.Scanner;

public class Q10798 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String[] arr = new String[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = scan.nextLine();
        }

        int maxLength = 0;
        for (String str : arr) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length()) {
                    System.out.print(arr[j].charAt(i));
                }
            }
        }
    }
}
