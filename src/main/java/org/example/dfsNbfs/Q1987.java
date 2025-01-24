package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1987 {
    static char[][] board;
    static  int R,C;
    static boolean[] visited;
    static ArrayList<Integer> count = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0,0,1);

        System.out.println(max);


    }

    static void dfs(int w,int h,int depth){

        if (w < 0 || h < 0 || w >= R || h >= C) {
            return;
        }

        int alphaIndex = board[w][h] - 'A';

        if(visited[alphaIndex]){
           return;
        }
        visited[alphaIndex] = true;
        max = Math.max(max,depth);

        dfs(w + 1, h, depth + 1); // 아래
        dfs(w - 1, h, depth + 1); // 위
        dfs(w, h + 1, depth + 1); // 오른쪽
        dfs(w, h - 1, depth + 1); // 왼쪽

        visited[alphaIndex] = false;

    }

}