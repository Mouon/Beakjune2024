package org.example.math;

import java.util.Scanner;

/**
 * 시간 초과 에바네!
 * 블로그 보겠다!
 *
 * 이후 배열 X를 돌면서 각 값의 배수 인덱스의 값이 0이 아니면 점수를 증감하자.
 * */
public class Q27172 {
    static int N, INF = 0;
    static int[] players, scores;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        players = new int[N];
        scores = new int[N+1];

        for(int i = 0;i<N;i++){
            players[i] = scan.nextInt();
            INF = Math.max(INF, players[i]);
        }

        int[] pos = new int[INF+1];

        for (int i = 0; i < N; i++){
            pos[players[i]] = i+1;
        }

        // pos[mod] = mod 의 인덱스 + 1
        for(int mod : players){
            for(int j = mod*2;j<=INF;j+=mod){
                // players 의 배수가 있다면 그아이는 -1, players 는 +1
                if(pos[j]!=0){
                    scores[pos[j]]--;
                    scores[pos[mod]]++;
                }
            }

        }

        for(int i = 1;i<=N;i++){
            System.out.print(scores[i] + " ");
        }

    }
}
