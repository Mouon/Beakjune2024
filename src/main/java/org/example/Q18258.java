package org.example;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count=Integer.parseInt(br.readLine());
        StringTokenizer command;
        Deque<Integer> queue = new LinkedList<>();

        while (count-->0){
            command=new StringTokenizer(br.readLine()," ");
            switch (command.nextToken()){
                case "push":
                    queue.offer(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.isEmpty()?-1:queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty()?-1:queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty()?-1:queue.peekLast()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty()?1:0).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }


}
