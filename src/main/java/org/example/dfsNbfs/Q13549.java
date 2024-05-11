package org.example.dfsNbfs;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q13549 {

    static int sec=0;
    static int su;
    static int dong;


    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split(" ");

        su=Integer.parseInt(list[0]);
        dong=Integer.parseInt(list[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{su, 0});
        boolean[] visited = new boolean[100001];

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nPosition = now[0];
            sec = now[1];
            if (nPosition == dong) {
                break;
            }

            visited[nPosition] = true;

            if (nPosition * 2 <= 100000 && !visited[nPosition * 2]) {
                pq.offer(new int[]{nPosition * 2, sec});
            }
            if (nPosition < dong && nPosition + 1 <= 100000 && !visited[nPosition + 1]) {
                pq.offer(new int[]{nPosition + 1, sec + 1});
            }
            if (nPosition - 1 >= 0 && !visited[nPosition - 1]) {
                pq.offer(new int[]{nPosition - 1, sec + 1});
            }
        }

        System.out.println(sec);

    }

}
