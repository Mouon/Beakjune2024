package org.example.listNArray;

import java.util.*;

public class Q3665 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int time=1;time<=T;time++){
            int N = scan.nextInt();

            int[] inDegree = new int[N+1];
            int[] array = new int[N+1];
            for(int j=1;j<=N;j++){
                array[j] = scan.nextInt();
            }

            List<Integer>[] list = new ArrayList[N+1];

            for(int i=1;i<=N;i++){
                list[i] = new ArrayList<>();
            }

            for(int i=1;i<=N;i++) {
                int from = array[i];
                for(int j=i+1;j<=N;j++) {
                    list[from].add(array[j]);
                    inDegree[array[j]]++;
                }
            }

            int M = scan.nextInt();
            for(int i=0;i<M;i++){
                int front = scan.nextInt();
                int back = scan.nextInt();

                if(list[front].contains(back)){
                    list[front].remove((Integer)back);
                    list[back].add(front);
                    inDegree[front]++;
                    inDegree[back]--;
                }else {
                    list[back].remove((Integer)front);
                    list[front].add(back);
                    inDegree[back]++;
                    inDegree[front]--;
                }
            }
            Queue<Integer> queue = new LinkedList<>();

            int cnt =0;
            for(int i=1; i<=N;i++){
                if(inDegree[i]==0){
                    cnt++;
                    queue.add(i);
                }
            }

            if(cnt>1){
                System.out.println("?");
                continue;
            }

            int result =0;
            StringBuilder sb = new StringBuilder();
            boolean isFinished = false;
            for(int i=1;i<=N;i++){
                if(queue.isEmpty()){
                    System.out.println("IMPOSSIBLE");
                    isFinished=true;
                    break;
                }
                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                for(int to : list[from]){
                    inDegree[to]--;
                    if(inDegree[to]==0){
                        queue.add(to);
                    }
                }

            }
            if(isFinished){
                continue;
            }
            System.out.println(sb);

        }
    }
}
