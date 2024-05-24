package org.example.math;

import java.util.Scanner;


/**
 * 팩토리얼 N!에서 끝에 있는 0의 개수를 구하는 수학적 원리는 10의 배수의 개수를 세는 것
 * 팩토리얼에서는 2의 개수가 5의 개수보다 항상 많습니다. 예를 들어, 10!을 계산하면 2는 매우 많이 포함되지만 5는 상대적으로 적게 포함됩니다.
 * 따라서, 끝에 있는 0의 개수는 5의 배수의 개수에 의해 결정됩니다.
 * */
public class Q1676 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;

        // 1부터 N까지 숫자 중 5의 배수의 개수를 세기
        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }

        System.out.println(count);
    }
}
