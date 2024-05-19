package org.example.implement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Q3009 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String[][] str = new String[3][2];
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();
        int x = 0,y=0;
        for(int i=0;i<3;i++){
            String input = scan.nextLine();
            str[i]=input.split(" ");
            int xValue = Integer.parseInt(str[i][0]);
            int yValue = Integer.parseInt(str[i][1]);

            mapX.put(xValue, mapX.getOrDefault(xValue, 0) + 1);
            mapY.put(yValue, mapY.getOrDefault(yValue, 0) + 1);
        }

        for (Integer key : mapX.keySet()) {
            if (mapX.get(key) == 1) {
                x = key;
                break;
            }
        }

        for (Integer key : mapY.keySet()) {
            if (mapY.get(key) == 1) {
                y = key;
                break;
            }
        }


        System.out.println(x+" "+y);

    }

}
