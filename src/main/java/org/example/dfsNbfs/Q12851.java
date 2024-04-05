package org.example.dfsNbfs;

import java.io.IOException;
import java.util.*;

public class Q12851 {

    static int sec=0;
    static ArrayList<Integer> secArr=new ArrayList<>();

    static int[] count=new int[100001];

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        int N= Integer.parseInt(arr[0]);
        int K= Integer.parseInt(arr[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{N, 0});
        boolean[] visited=new boolean[1000001];

        while (!pq.isEmpty()){

            int[] now=pq.poll();
            int nPosition=now[0];
            sec=now[1];

            if(K==nPosition){
                secArr.add(sec);
                count[sec]+=1;
            }


            visited[nPosition]=true;

            if (nPosition * 2 <= 100001 && !visited[nPosition * 2]) {
                pq.offer(new int[]{nPosition * 2, sec+1});
            }
            if (nPosition + 1 <= 100000 && !visited[nPosition + 1]) {
                pq.offer(new int[]{nPosition + 1, sec + 1});
            }
            if (nPosition - 1 >= 0 && !visited[nPosition - 1]) {
                pq.offer(new int[]{nPosition - 1, sec + 1});
            }

        }

        Collections.sort(secArr);
        System.out.println(secArr.get(0));
        System.out.println(count[secArr.get(0)]);

    }


}
