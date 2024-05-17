package org.example.implement;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q25305 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        int N= Integer.parseInt(arr[0]);
        int K= Integer.parseInt(arr[1]);
        int[] intScore = new int[N];
        str = scan.nextLine();
        intScore= Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(intScore);
        System.out.println(intScore[N-K]);

    }
}
