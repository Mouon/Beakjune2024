package org.example;

import java.io.IOException;
import java.util.Scanner;

/**
 * B의 친구거나 B와 친구인 C가 필요하다.
 *
 * */

public class Q1058 {

    public static int count;
    public static String[][] people;
    public static int[] friends;
    public static int max;

    public static void main(String[] args) throws IOException {

        max=0;
        Scanner scan = new Scanner(System.in);
        count =   scan.nextInt();
        scan.nextLine();
        people = new String[count][count];
        friends = new int[count];


        for (int i=0; i<count; i++){
            String str = scan.nextLine();
            people[i] = str.split("");
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) continue;
                if (people[i][j].equals("Y") || hasMidFriend(i, j)) {
                    friends[i]++;
                }
            }
            max = Math.max(max, friends[i]);
        }

        System.out.println(max);

    }

    private static boolean hasMidFriend(int i, int j) {
        for (int k = 0; k < count; k++) {
            if (people[i][k].equals("Y") && people[k][j].equals("Y")) {
                return true;
            }
        }
        return false;
    }


}
