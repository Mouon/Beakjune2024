package org.example.dp;

import java.util.*;

public class Q1074 {
    static int N,r,c,size;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        N = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();

        size = (int)Math.pow(2,N);

        search(0,0,size);



    }

    static void search(int x,int y,int size) {

        if (size == 1) {
            System.out.println(count);
            return;
        }

        int half = size / 2;

        if (r < x + half && c < y + half) {
            // 1사분면 (좌상)
            search(x, y, half);
        } else if (r < x + half) {
            // 2사분면 (우상)
            count += half * half;
            search(x, y + half, half);
        } else if (c < y + half) {
            // 3사분면 (좌하)
            count += 2 * half * half;
            search(x + half, y, half);
        } else {
            // 4사분면 (우하)
            count += 3 * half * half;
            search(x + half, y + half, half);
        }
    }

}
