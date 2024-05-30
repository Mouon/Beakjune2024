package org.example.stackQ;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Q10773 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int sum=0;
        int N = scan.nextInt();
        for(int i =0;i<N;i++){
            int input = scan.nextInt();
            if(input==0){
                stack.pop();
            }else {
                stack.push(input);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

    }
}
