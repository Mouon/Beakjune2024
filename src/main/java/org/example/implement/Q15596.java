package org.example.implement;

import java.io.IOException;
import java.util.Scanner;

public class Q15596 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scan.nextInt();
        }
        System.out.println(sum(num));


    }

    static long sum(int[] a){

        long ans=0;
        for(int i : a){
            ans+=i;
        }
        return ans;
    }

}
