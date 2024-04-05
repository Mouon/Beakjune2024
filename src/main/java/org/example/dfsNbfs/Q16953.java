package org.example.dfsNbfs;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q16953 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");

        long A = Integer.parseInt(arr[0]);
        long B = Integer.parseInt(arr[1]);
        long count = 0;
        long nowNum=0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Math.toIntExact(x[1] - y[1]));
        pq.offer(new long[]{A, 0});

        boolean[] visited=new boolean[1000000001];

        while (!pq.isEmpty()) {
            long[] now = pq.poll();
            nowNum = now[0];
            count = now[1];

            if (nowNum == B) {
                break;
            }

            visited[(int) nowNum] = true;

            if (nowNum * 2 <= B && !visited[(int) (nowNum * 2)]) {
                pq.offer(new long[]{nowNum * 2, count + 1});
            }

            if (nowNum*10+1 <= B && !visited[(int)nowNum*10+1]) {
                pq.offer(new long[]{nowNum*10+1, count + 1});
            }
        }
        if(nowNum!=B){
            System.out.println("-1");
        }else{
            System.out.println(count+1);
        }

    }

}

