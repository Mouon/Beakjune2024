package org.example.implement;

import java.util.HashMap;
import java.util.Scanner;

public class Q5622 {
    public static void main(String[] args) throws Exception {

        int sec=0;
        HashMap<String,String> alpha = new HashMap<String,String>();
        alpha.put("A","2");
        alpha.put("B","2");
        alpha.put("C","2");
        alpha.put("D","3");
        alpha.put("E","3");
        alpha.put("F","3");
        alpha.put("G","4");
        alpha.put("H","4");
        alpha.put("I","4");
        alpha.put("J","5");
        alpha.put("K","5");
        alpha.put("L","5");
        alpha.put("M","6");
        alpha.put("N","6");
        alpha.put("O","6");
        alpha.put("P","7");
        alpha.put("Q","7");
        alpha.put("R","7");
        alpha.put("S","7");
        alpha.put("T","8");
        alpha.put("U","8");
        alpha.put("V","8");
        alpha.put("W","9");
        alpha.put("X","9");
        alpha.put("Y","9");
        alpha.put("Z","9");


        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] num=str.split("");

        for(int i=0;i<str.length();i++){
            sec+=Integer.parseInt(alpha.get(num[i]))+1;
        }


        System.out.println(sec);




    }

}
