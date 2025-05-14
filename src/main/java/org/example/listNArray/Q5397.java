package org.example.listNArray;

import java.util.Scanner;
import java.util.Stack;

public class Q5397 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<count;i++){
            String input = scan.nextLine();
            System.out.println(findPw(input));
        }

    }

    static String findPw(String input){
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='<'&&!stack.isEmpty()){
                stack2.add(stack.pop());
            } else if (input.charAt(i)=='>'&&!stack2.isEmpty()) {
                stack.add(stack2.pop());
            } else if (input.charAt(i)=='-'&&!stack.isEmpty()) {
                stack.pop();
            } else if(input.charAt(i)!='<'&&input.charAt(i)!='>'&&input.charAt(i)!='-'){
                stack.add(input.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        while (!stack2.isEmpty()) sb.append(stack2.pop());

        return sb.toString();

    }
}
