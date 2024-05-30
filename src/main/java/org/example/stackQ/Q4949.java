package org.example.stackQ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        ArrayList<String> ans = new ArrayList<>();
        while (true) {
            String str = scan.nextLine();
            if (str.equals(".")) {
                break;
            }
            if (isBalanced(str)) {
                ans.add("yes");
            } else {
                ans.add("no");
            }
        }

        for(String str : ans){
            sb.append(str+"\n");
        }

        System.out.println(sb);
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }else if(ch==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }else if(ch==']'){
                if(stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
