package org.example.dp;

import java.util.Scanner;


/**
 * 아 뭐지
 *
 * 재귀를 메모리 제이션으로 이거까지는 알았는데....
 * */
public class Q9184 {
    static int[][][] dp = new int[121][121][121];
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int c = 0;

        while (true){
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            if(a==-1&&b==-1&&c==-1) return;
            System.out.println("w("+a+", "+b+", "+c+") = " + W(a,b,c));
        }

    }

    static int W(int a, int b, int c){

        if( 0 < a && a <= 50 && 0 < b
                && b <= 50 && 0 < c && c <= 50 &&dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if(a<=0||b<=0||c<=0){
            return 1;
        }else if(a>20||b>20||c>20){
            return dp[20][20][20] = W(20,20,20);
        } else if(a<b && b<c){
            return dp[a][b][c] = W(a,b,c-1)+ W(a,b-1,c-1)- W(a,b-1,c);
        }else {
            return dp[a][b][c] = W(a-1,b,c) + W(a-1,b-1,c)
                    + W(a-1,b,c-1) - W(a-1,b - 1,c-1) ;
        }
    }
}
