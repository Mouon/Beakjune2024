package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q5086 {

    public static void main(String[] args) throws IOException {

        Scanner scan =new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        while (true){
            String str = scan.nextLine();
            if(str=="0 0") {
                break;
            }
            String[] num = str.split(" ");
            int num1=Integer.parseInt(num[0]);
            int num2=Integer.parseInt(num[1]);
            if(num1==0&&num2==0) {
                break;
            }
            if(num2 != 0 && num1/num2!=0&&num1%num2==0){
                ans.add("multiple");
            } else if (num1 != 0 && num2/num1!=0&&num2%num1==0) {
                ans.add("factor");
            } else{
                ans.add("neither");
            }

        }
        for(String result : ans){
            System.out.println(result);
        }
    }

}
