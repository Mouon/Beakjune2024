package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모르겄다...
public class Q2239 {
    static int[][] board = new int[9][9];
    static boolean end;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            String input = br.readLine();
            for (int j = 0; j < 9; ++j) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        dfs(0);

        for(int i=0;i<9;i++){
            for (int j = 0; j < 9; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int depth) {
        if (depth == 81) {
            end = true;
            return;
        }

        int y = depth / 9;
        int x = depth % 9;

        if(board[y][x] != 0){
            dfs(depth + 1);
        }else{
            for(int i = 1; i<=9; i++){
                if(!isValid(y,x,i)){
                    continue;
                }
                board[y][x] = i;
                dfs(depth+1);
                if (end) return;
                board[y][x] = 0;
            }
        }
    }

    public static boolean isValid(int y, int x, int n){
        for (int i = 0; i < 9; i++){
            if(board[y][i] == n || board[i][x] == n){
                return false;
            }
        }

        int yy = y/3 * 3;
        int xx = x/3 * 3;
        for(int i = yy; i< yy + 3; i++){
            for (int j = xx; j < xx + 3; j++) {
                if (board[i][j] == n){
                    return false;
                }
            }
        }
        return true;
    }
}
