package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q11050 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr =str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        int result=fact(N)/(fact(N-K)*fact(K));

        System.out.println(result);

    }

    public static int fact(int n){
        int result=1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }
}
