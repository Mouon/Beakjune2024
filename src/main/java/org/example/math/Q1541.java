package org.example.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1541 {
    static String[] arr;
    static ArrayList<Long> list;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        arr = str.split("-");
        list = new ArrayList<>();
        calSum();
        System.out.println(calMinus());

    }

    public static void calSum(){
        for(String num : arr){
            if(num.length()>=2){
                int sum=0;
                String[] temp = num.split("\\+");
                for (int i=0;i<temp.length;i++){
                    sum+=Integer.parseInt(temp[i]);
                }
                list.add((long) sum);
            }else {
                list.add(Long.valueOf(num));
            }
        }
    }

    public static long calMinus(){
        long result = list.get(0);
        for(int j=1;j<list.size();j++){
            result-=list.get(j);
        }
        return result;
    }
}
