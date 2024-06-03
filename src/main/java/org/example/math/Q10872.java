package org.example.math;

import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int init = 1;
        int N = scan.nextInt();

        for(int i=1;i<=N;i++){
            init*=i;
        }

        System.out.println(init);

    }
}
