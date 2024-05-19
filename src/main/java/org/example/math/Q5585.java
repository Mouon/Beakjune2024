package org.example.math;

import java.util.Scanner;

public class Q5585 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int change = 1000-scan.nextInt();
        int count=0;

        if(change/500!=0){
//            System.out.println("before : "+change);
            count+=change/500;
            change%=500;
//            System.out.println("count : "+count);
//            System.out.println(change);

        }
        if(change/100!=0){
//            System.out.println("before : "+change);
            count+=change/100;
            change%=100;
//            System.out.println("count : "+count);
//            System.out.println(change);

        }
        if(change/50!=0){
//            System.out.println("before : "+change);
            count+=change/50;
            change%=50;
//            System.out.println("count : "+count);
//            System.out.println(change);

        }
        if(change/10!=0){
//            System.out.println("before : "+change);
            count+=change/10;
            change%=10;
//            System.out.println("count : "+count);
//            System.out.println(change);

        }
        if(change/5!=0){
//            System.out.println("before : "+change);
            count+=change/5;
            change%=5;
//            System.out.println("count : "+count);
//            System.out.println(change);

        }
        count+=change;


        System.out.println(count);

    }

}
