package org.example.stackQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Q11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int i=0;
        int j=0;
        String[] list = new String[count];
        HashMap<Integer,Integer> map = new HashMap<>();

        while (i<count){
            list[i] = br.readLine();
            i++;
        }
        br.close();

        while (j<count){
            String[] command = list[j].split(" ");
            switch (command[0]) {
                case "add":
                    map.put(Integer.parseInt(command[1]),Integer.parseInt(command[1]));
                    break;
                case "remove":
                    if (map.isEmpty()) {
                    } else {
                        map.remove(Integer.parseInt(command[1]));
                    }
                    break;
                case "check":
                    if(map.containsKey(Integer.parseInt(command[1]))){
                        System.out.println("1");
                    }else {
                        System.out.println("0");
                    }
                    break;
                case "toggle":
                    if(map.containsKey(Integer.parseInt(command[1]))){
                        map.remove(Integer.parseInt(command[1]));
                    }else {
                        map.put(Integer.parseInt(command[1]),Integer.parseInt(command[1]));
                    }
                    break;
                case "all":
                    map.clear();
                    for(int k=1;k<21;k++){
                        map.put(k,k);
                    }
                    break;
                case "empty:":
                    map.clear();
                    break;
            }
            j++;
        }

    }

}
