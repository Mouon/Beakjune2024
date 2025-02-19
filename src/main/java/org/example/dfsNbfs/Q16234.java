package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16234 {
    static int N,L,R;
    static int[][] A;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();

        A = new int[N][N];

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                A[r][c]= scan.nextInt();
            }
        }

        int count = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        moved = move(r,c);
                    }
                }
            }

            if (!moved) break;
            count++;
        }

        System.out.println(count);
    }


    static boolean move(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> united = new LinkedList<>();
        queue.add(new int[]{x,y});
        united.add(new int[]{x, y});

        visited[x][y] = true;
        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];
            sum += A[curX][curY];
            count += 1;

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
                        && !visited[nextX][nextY]) {
                    int differ = Math.abs(A[curX][curY] - A[nextX][nextY]);
                    if (differ >= L && differ <= R) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        united.add(new int[]{nextX, nextY});
                    }
                }
            }

        }

        if (united.size() == 1) return false;

        int newPopulation = sum / count;
        for (int[] index : united) {
            A[index[0]][index[1]] = newPopulation;
        }

        return true;

    }
}
