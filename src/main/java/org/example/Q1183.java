package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문제
 * 마법사 N명이 머글 문화를 이해하기 위해 머글과 약속을 잡았다. 각 마법사는 한 명의 머글을 만날 예정이다. 하지만, 마법사는 약속 시간보다 빨리 또는 늦게 도착할 수 있기 때문에 고민에 빠졌다.
 * 결국 기다리는 시간을 최소화 하기 위해 모든 약속 시간을 T씩 미루려고 한다. 기다리는 시간은 먼저 도착한 사람이 늦게 도착한 사람이 도착할 때까지 기다리는 시간을 의미한다.
 *
 * 마법사의 약속 시간은 A1, A2, ..., AN이고, 도착 시간은 B1, B2, ..., BN이다. 약속 시간을 T만큼 미루면, 기다리는 시간의 합은 |Ai + T - Bi|의 합과 같다.
 * 기다리는 시간의 합이 최소가 되는 서로 다른 정수 T의 개수를 구해보자.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. 다음 N개의 줄에 Ai, Bi가 주어진다.
 *
 * 출력
 * 첫째 줄에 기다리는 시간의 합이 최소인 서로 다른 정수 T의 개수를 출력한다.
 *
 * 제한
 * 1 ≤ N ≤ 50
 * 1 ≤ Ai, Bi ≤ 109
 * */
public class Q1183 {
    private static int N;
    private static long[] A,B;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        A = new long[N];
        B = new long[N];
        List<Long> differences = new ArrayList<>();


        for(int i=0;i<N;i++){
            A[i] = scan.nextLong();
            B[i] = scan.nextLong();
            differences.add(A[i] - B[i]);

        }

        if (N % 2 == 1) {
            System.out.println(1);
        }
        else {
            Collections.sort(differences);
            long leftMedian = differences.get(N/2 - 1);
            long rightMedian = differences.get(N/2);
            System.out.println(rightMedian - leftMedian + 1);
        }
    }

    /**
     * 수학적인것
     * 중앙값에대한 이해
     * */
}
