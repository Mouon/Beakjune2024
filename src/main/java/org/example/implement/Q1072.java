package org.example.implement;

import java.util.Scanner;

public class Q1072 {
    static long X,Y;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        X = scan.nextLong();
        Y = scan.nextLong();

        long per = (Y*100)/X;

        long left = 1;
        long right = X;
        long mid = (left+right)/2;
        long ans = -1;
        while (left<=right){
            System.out.println(mid);
            mid = (left+right)/2;
            long now = ((Y+mid) * 100)/(X+mid);
            if(now>per){
                ans = mid;// 승률이 올랐을때가 점수
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        System.out.print(ans);
    }
}
