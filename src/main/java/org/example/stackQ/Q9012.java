package org.example.stackQ;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        String[] ans = new String[N];
        for (int i = 0; i < N; i++) {
            ans[i] = "YES";
            Stack<Character> stack = new Stack<>();
            String str = scan.nextLine();
            for(char ch : str.toCharArray()){
                if(ch==')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        ans[i]="NO";
                    }
                }else{
                    stack.push(ch);
                }
            }
            if(!stack.isEmpty()){
                ans[i]="NO";
            }
        }

        for (String result : ans) {
            System.out.println(result);
        }
    }
}
