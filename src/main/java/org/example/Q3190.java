package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뱀을 큐로 구현했다가 수정
 * */

public class Q3190 {

    static int[][] board;
    static int N, K, L;

    /** 방향순서 난관 오른쪽 기준 모호
     * 오른쪽, 아래쪽, 왼쪽, 위쪽
     * 배열의 [][]랑 (,)이거랑 헷갈려서 해맴
     * */
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static HashMap<Integer,String> turnSignal = new HashMap<>();
    static ArrayList<int[]> snake= new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board=new int[N][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1]=1;
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            turnSignal.put(sec,direction);
        }

        play();


    }


    static void play(){
        int time = 0;
        int currentX = 0;
        int currentY = 0;
        int direction = 0;
        snake.add(new int[] { 0, 0 });

        while (true){

            time++;
            int nowX = currentX+dx[direction];
            int nowY = currentY+dy[direction];


            if(nowX<0 || nowY <0 || nowX > N-1 || nowY > N-1){
                break;
            }

            if(validateSnake(nowX,nowY)){
                break;
            }

            if(board[nowX][nowY] == 1){
                snake.add(new int[] {nowX,nowY});
                board[nowX][nowY] = 0;
            } else {
                snake.add(new int[] {nowX,nowY});
                snake.remove(0);
            }

            if(turnSignal.containsKey(time)){
                if(turnSignal.get(time).equals("L")){
                    direction = (direction + 3) % 4;
                }else {
                    direction = (direction + 1) % 4;
                }
            }

            currentX = nowX;
            currentY = nowY;

        }

        System.out.println(time);

    }

    static boolean validateSnake(int nowX,int nowY){

        for(int i=0;i<snake.size()-1;i++){
            int[] temp = snake.get(i);
            if(nowX==temp[0]&&nowY==temp[1]){
                return true;
            }
        }
        return false;
    }
}
