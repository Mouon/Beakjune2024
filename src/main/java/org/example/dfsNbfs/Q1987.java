package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1987 {
    static char[][] board;
    static int R, C;
    static boolean[] isUsed; // 알파벳 중복 체크
    static int max = 0; // 최대 경로 길이
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        isUsed = new boolean[26]; // 알파벳 26개에 대한 중복 체크

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray(); // 문자열을 char 배열로 저장
        }



        dfs(0,0,1);

        System.out.println(max);

    }

    static void dfs(int w,int h,int depth){

        if (w < 0 || h < 0 || w >= R || h >= C) {
            return;
        }

        int alphabetIndex = board[w][h] - 'A';

        if (isUsed[alphabetIndex]) {
            return;
        }

        isUsed[alphabetIndex] = true;
        max = Math.max(max, depth); // 최대 경로 갱신

        dfs(w + 1, h, depth + 1); // 아래
        dfs(w - 1, h, depth + 1); // 위
        dfs(w, h + 1, depth + 1); // 오른쪽
        dfs(w, h - 1, depth + 1); // 왼쪽

        isUsed[alphabetIndex] = false;
    }

}
