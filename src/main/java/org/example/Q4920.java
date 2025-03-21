package org.example;

import java.io.*;
import java.util.*;

public class Q4920 {
    static int[][][] standard = {
            {{0, 0, 0, 0}, {0, 1, 2, 3}},
            {{0, 1, 2, 3}, {0, 0, 0, 0}},
            {{0, 0, 1, 1}, {0, 1, 1, 2}},
            {{0, 1, 1, 2}, {0, 0, -1, -1}},
            {{0, 0, 0, 1}, {0, 1, 2, 2}},
            {{0, 1, 2, 2}, {0, 0, 0, -1}},
            {{0, 1, 1, 1}, {0, 0, 1, 2}},
            {{0, 0, 1, 2}, {0, 1, 0, 0}},
            {{0, 1, 1, 1}, {0, -1, 0, 1}},
            {{0, 1, 1, 2}, {0, 0, 1, 0}},
            {{0, 0, 0, 1}, {0, 1, 2, 1}},
            {{0, 1, 1, 2}, {0, -1, 0, 0}},
            {{0, 0, 1, 1}, {0, 1, 1, 0}},
    };
    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
            board = new int[N][N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 모든 위치에 대해 블록을 놓아보고 최댓값 갱신
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int a = 0; a < standard.length; a++) {
                        int sum = 0;
                        boolean flag = true;

                        // 블록의 네 개 칸에 대한 위치 확인 및 합 계산
                        for (int b = 0; b < 4; b++) {
                            int nx = i + standard[a][0][b];
                            int ny = j + standard[a][1][b];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                sum += board[nx][ny];
                            } else {
                                flag = false;
                                break;
                            }
                        }

                        // 유효한 위치에 놓을 수 있는 경우 최댓값 갱신
                        if (flag) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(idx + ". " + max);
            idx++;
        }
    }
}