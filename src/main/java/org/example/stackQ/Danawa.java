package org.example.stackQ;

import java.util.*;

/**
 *  스택의 top이 target보다 크면 실패
 * */
public class Danawa {
    public boolean solution (int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int current = 1;
        for (int target : arr) {
            while (current<n && (stack.isEmpty()||stack.peek()<target)){
                stack.push(current);
                current++;
            }
            if(!stack.isEmpty() && stack.peek()==target){
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}

//public boolean solution (int[] arr) {
//    Stack<Integer> stack = new Stack<>();
//    int n = arr.length;
//    int current = 1;
//    for (int target : arr) {
//        while (current <=n && (stack.isEmpty() || stack.peek() < target)){
//            stack.push(current);
//            current++;
//        }
//        if (!stack.isEmpty() && stack.peek()==target){
//            stack.pop();
//        }else {
//            return false;
//        }
//    }
//    return true;
//}