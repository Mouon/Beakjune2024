package org.example.math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Q2576 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int[] num = new int[7];
        int sum =0;
        for(int i=0;i<7;i++){
            num[i]=scan.nextInt();
        }
        ArrayList<Integer> odd = new ArrayList<>();

        for(int n : num){
            if(n%2!=0) {
                odd.add(n);
                sum+=n;
            }
        }
        Collections.sort(odd);
        if(odd.size()==0){
            System.out.println("-1");
        }else {
            System.out.println(sum);
            System.out.println(odd.get(0));
        }
    }
}