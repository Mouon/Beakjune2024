package org.example.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q1874 {

    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i=0;i<N;i++){
            arr.add(scan.nextInt());
        }

        int num=1;

        for(int i=0;i< arr.size();i++){
            int su = arr.get(i);
            if(su>=num){
                while (su>=num){
                    stack.push(num++);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            }else {
                int pop = stack.pop();
                if(pop>su){
                    System.out.println("NO");
                    return;
                }else {
                    result.add("-");
                }
            }
        }


        for (int i=0;i< result.size();i++){
            System.out.println(result.get(i));
        }

    }

}
