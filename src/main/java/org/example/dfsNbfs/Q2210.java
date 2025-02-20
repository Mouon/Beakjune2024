package org.example.dfsNbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Q2210 {
    public static int N;
    public static int M;
    public static int[][] box;
    static ArrayList<String> ans = new ArrayList<>();

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        box = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                box[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, String.valueOf(box[i][j]), 1);
            }
        }

        System.out.println(ans.size());
    }

    static void dfs(int x, int y, String str, int depth) {
        if (depth == 6) {
            if(!ans.contains(str)){
                ans.add(str);
            }
            return;
        }
        for (int k = 0; k < 4; k++) {
            int curX = x + dx[k];
            int curY = y + dy[k];
            if (curX >= 0 && curY >= 0 && curX < 5 && curY < 5) {
                dfs(curX, curY, str + box[curX][curY], depth + 1);
            }
        }
    }
}
