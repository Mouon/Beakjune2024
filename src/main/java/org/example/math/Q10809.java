package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10809 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] list = str.split("");

        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int index = currentChar - 'a';
            if (position[index] == -1) {
                position[index] = i;
            }
        }


        for(int i : position){
            System.out.print(i+" ");
        }

    }

}
