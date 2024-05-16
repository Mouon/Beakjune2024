package org.example.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q10818 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        int[] num = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(num);
        System.out.println(num[0]+" "+num[N-1]);

    }

}
