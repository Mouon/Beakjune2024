package org.example.math;

import java.util.Scanner;

public class Q6064 {
    /**
     * x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다.
     * 같은 방식으로 만일 y < N이면 y' = y + 1이고,
     * 그렇지 않으면 y' = 1
     * */

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);

        int K = scan.nextInt();

        for(int i =0;i<K;i++){
            int M = scan.nextInt();
            int N = scan.nextInt();
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            int ans = -1;

            for(int j = x; j<N*M; j+=M){
                if(j%N==y){
                    ans = j+1;
                    break;
                }
            }
            System.out.println(ans);

        }


    }

}
