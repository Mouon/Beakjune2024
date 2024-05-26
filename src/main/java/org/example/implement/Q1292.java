package org.example.implement;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1292 {
    public static void main(String[] args) throws Exception {

        int sum=0;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=1;i<=K;i++){
            for(int j=0;j<i;j++){
                num.add(i);
            }
        }

        for (int i=N-1;i<K;i++){
            sum+=num.get(i);
        }

        System.out.println(sum);

    }
}
