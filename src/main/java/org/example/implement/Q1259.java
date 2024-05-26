package org.example.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1259 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        int j=0;
        while (true){
            String num = scan.nextLine();
            if(num.equals("0")){
                break;
            }
            arr.add(num);
        }

        for(String str : arr){
            boolean isPalindrome = true;
            ArrayList<Character> chArr = new ArrayList<>();
            for(char ch : str.toCharArray()){
                chArr.add(ch);
            }
            for(int i=0;i<chArr.size();i++){
                if(chArr.get(i)!=chArr.get(chArr.size()-i-1)){
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                ans.add("yes");
            } else {
                ans.add("no");
            }
        }

        for(String str : ans) {

            System.out.println(str);

        }


        }
}
