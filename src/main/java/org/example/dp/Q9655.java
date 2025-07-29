package org.example.dp;

import java.util.Scanner;

// 완벽하게 한다는개 뭐임?
// 상근 = 홀
// 창영 = 짝
public class Q9655 {
    static String[] players = {"SK","CY"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        if(N>=3){
            System.out.println(players[(N-3)%2]);
        }else {
            System.out.println(players[N-1]);
        }



    }
}
