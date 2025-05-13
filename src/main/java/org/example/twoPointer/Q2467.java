package org.example.twoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2467 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i< N; i++){
            list.add(scan.nextInt());
        }

        int m = 0, p = N-1;

        int n1=0, n2=0;
        int max = Integer.MAX_VALUE;

        while (m<p){
            int temp = list.get(m) + list.get(p);
            if(max > Math.abs(temp)){
                max = Math.abs(temp);
                n1 = list.get(m);
                n2 = list.get(p);
            }
            if(temp > 0){
                p--;
            }else if(temp < 0){
                m++;
            }else {
                n1 = list.get(m);
                n2 = list.get(p);
                break;
            }
        }
        System.out.println(n1 +" "+n2);
    }
}
