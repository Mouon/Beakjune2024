package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int i=0;
        int j=0;
        String[] list = new String[count];
        ArrayList<Integer> stack = new ArrayList<>();

        while (i<count){
            list[i] = br.readLine();
            i++;
        }
        br.close();

        while (j<count){
            String[] command = list[j].split(" ");
            switch (command[0]) {
                case "push":
                    stack.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.remove(stack.size() - 1));
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
                    break;
            }
            j++;
        }
        
    }

}
