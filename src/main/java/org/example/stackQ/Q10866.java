package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        String[] command;
        String[] list =new String[count];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<count;i++){
            list[i]=br.readLine();
        }
        for(int j=0;j<count;j++){
            command=list[j].split(" ");/** 명렬어 파악하는 중요 대목 */
            switch (command[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    System.out.println(deque.isEmpty()?-1:deque.removeFirst());
                    if(!deque.isEmpty())
                        deque.remove(0);
                    break;
                case "pop_back":
                    System.out.println(deque.isEmpty()?-1:deque.removeLast());
                    if(!deque.isEmpty())
                        deque.remove(0);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "front":
                    System.out.println(deque.isEmpty()?-1:deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.isEmpty()?-1:deque.peekLast());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty()?1:0);
                    break;

            }

        }

    }

}
