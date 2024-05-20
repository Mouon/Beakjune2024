package org.example.implement;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10953 {

    public static void main(String[] args) throws Exception {

        Scanner scan =new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] num = str.split(",");

            int num1=Integer.parseInt(num[0]);
            int num2=Integer.parseInt(num[1]);
            int temp=num1+num2;
            result.add(temp);
        }


        for (int ans:result){
            System.out.println(ans);
        }


    }
}
