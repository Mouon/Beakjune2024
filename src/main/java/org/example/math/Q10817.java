package org.example.math;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int[] num = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(num);
        System.out.println(num[1]);

    }

}
