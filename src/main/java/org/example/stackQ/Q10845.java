package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        String[] command;
        String[] list =new String[count];
        ArrayList<Integer> queue = new ArrayList<>();

        for(int i=0;i<count;i++){
            list[i]=br.readLine();
        }
        for(int j=0;j<count;j++){
            command=list[j].split(" ");
            switch (command[0]){
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty()?-1:queue.get(0));
                    if(!queue.isEmpty())
                        queue.remove(0);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "front":
                    System.out.println(queue.isEmpty()?-1:queue.get(0));
                    break;
                case "back":
                    System.out.println(queue.isEmpty()?-1:queue.get(queue.size()-1));
                    break;
                case "empty":
                    System.out.println(queue.isEmpty()?1:0);
                    break;

            }

        }

    }

}
