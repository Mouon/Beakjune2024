package org.example.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2581 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int A=scan.nextInt();
        int B=scan.nextInt();
        ArrayList<Integer> arr =new ArrayList<>();
        int sum=0;

        for(int i=A;i<=B;i++){
            if(isPrime(i)){
                sum+=i;
                arr.add(i);
            }
        }
        System.out.print(sum==0?"":sum+"\n");
        System.out.println(arr.size()==0?-1:arr.get(0));

    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
