package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M=0;
        for(int i = 1; i <= N; i++) {
            int number = i;
            int res = 0;

            /** 각 자리수를 추출하는데에 중요한 로직 */
            while(number > 0){
                res += number % 10;
                number /= 10;
            }

            if(res + i == N){
                M = i;
                break;
            }
        }

        System.out.println(M);

    }
}
