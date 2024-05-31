package org.example.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9085 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> sumList = new ArrayList<>();
        int sum=0;

        for(int i=0;i<N;i++){
            sum=0;
            int K = scan.nextInt();
            scan.nextLine();
            String str = scan.nextLine();
            String[] arr =str.split(" ");
            for(int j=0;j<K;j++){
                sum+=Integer.parseInt(arr[j]);
            }
            sumList.add(sum);
        }

        for(int num : sumList){
            System.out.println(num);
        }

    }
}
