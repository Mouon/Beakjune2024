package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190 {

    static int[][] board;
    static int N, K, L,T=0;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };


    static HashMap<Integer,String> turnSignal = new HashMap<>();
    static ArrayList<int[]> snake= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan =  new Scanner(System.in);
        N = scan.nextInt();

        board = new int[N][N];

        K = scan.nextInt();

        for(int i=0;i<K;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            board[x-1][y-1] = 1;
        }

        L = scan.nextInt();
        scan.nextLine();

        for(int i=0;i<L;i++){
            String str = scan.nextLine();
            String[] line = str.split(" ");
            int sec = Integer.parseInt(line[0]);
            String dic = line[1];

            turnSignal.put(sec,dic);
        }

        bfs(0,0);

        System.out.print(T);

    }

    static public void bfs(int startX,int startY){
        snake.add(new int[]{startX,startY});
        int direction = 0;

        while (true){
            T++;
            int x = startX+dx[direction];
            int y = startY+dy[direction];


            if(x<0 || y<0 || x > N-1 || y > N-1){
                break;
            }

            if(isSnake(x,y)){
                break;
            }

            if(board[x][y] == 1){
                snake.add(new int[] {x,y});
                board[x][y] = 0;
            } else {
                snake.add(new int[] {x,y});
                snake.remove(0);
            }

            if(turnSignal.containsKey(T)){
                if(turnSignal.get(T).equals("L")){
                    direction = (direction + 3) % 4;
                }else {
                    direction = (direction + 1) % 4;
                }
            }

            startX = x;
            startY =y;

        }
    }

    static boolean isSnake(int x,int y){
        for (int[] temp : snake) {
            if (x == temp[0] && y == temp[1]) {
                return true;
            }
        }
        return false;
    }

}
