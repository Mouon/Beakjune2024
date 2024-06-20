package org.example.stackQ;

import java.util.Scanner;
import java.util.Stack;

public class Q1918 {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split("");

        Stack<String> stack = new Stack<>();
        Stack<String> temp = new Stack<>();

        for (String s : arr) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("(") && !s.equals(")")) {
                stack.push(s);
            } else if(s.equals("(")){
                temp.push(s);
            } else if (s.equals(")")) {
                while (!temp.isEmpty() && !temp.peek().equals("(")){
                    stack.push(temp.pop());
                }
                temp.pop();
            }else {
                while (!temp.isEmpty() && pre(temp.peek())>=pre(s)){
                    stack.push(temp.pop());
                }
                temp.push(s);
            }
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        Stack<String> outputStack = new Stack<>();
        while (!stack.isEmpty()) {
            outputStack.push(stack.pop());
        }
        while (!outputStack.isEmpty()) {
            System.out.print(outputStack.pop());
        }
    }

    private static int pre(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }
}


