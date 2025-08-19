package org.example.implement;

import java.util.Scanner;

public class Q17266 {
    static int N,M;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        int before = scan.nextInt();
        int height = before;
        for (int i=1;i<M;i++){
            int place = scan.nextInt();
            height = Math.max(height, (place - before+1)/2);
            before = place;
        }
        height = Math.max(height, N - before);
        System.out.print(height);

    }
}
