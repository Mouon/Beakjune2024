package org.example.math;

import java.util.Scanner;

public class Q4948 {
    static boolean[] isPrime;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = 123457;
        while (true){
            num = scan.nextInt();
            if(num==0) break;
            System.out.println(calPrime(num));
        }

    }

    public static Long calPrime(int input){
        long result = 0;
        isPrime(2*input);
        for(int i = input+1; i<=2*input; i++){
            if(isPrime[i]){
                result++;
            }
        }

        return result;
    }

    public static void isPrime(int n){
        isPrime = new boolean[n+1];

        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j = i*i; j<= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
}
