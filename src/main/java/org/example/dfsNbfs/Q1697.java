package org.example.dfsNbfs;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1697 {

     static int sec=0;
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr=str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{N, sec});
        boolean[] visited = new boolean[100001];

        while (!pq.isEmpty()){
            int[] now=pq.poll();
            int nowPos=now[0];
            sec=now[1];
            if(nowPos==K){
                break;
            }
            visited[nowPos]=true;

            if(nowPos*2<100001&& visited[nowPos*2]!=true){
                pq.offer(new int[]{nowPos*2, sec+1});
            }
            if(nowPos+1<100001&& visited[nowPos+1]!=true){
                pq.offer(new int[]{nowPos+1, sec+1});
            }
            if(nowPos-1>=0&& visited[nowPos-1]!=true){
                pq.offer(new int[]{nowPos-1, sec+1});
            }

        }

        System.out.println(sec);

    }

}
