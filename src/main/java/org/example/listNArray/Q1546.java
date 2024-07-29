package org.example.listNArray;

import java.util.Arrays;
import java.util.Scanner;

public class Q1546 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arr[] = new int[N];
        double sum=0;
        int max=0;
        double avg ;
        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
            if(max<arr[i]){
                max=arr[i];
            }
            sum+=arr[i];
        }
        avg=sum*100/max/N;
        System.out.println(avg);

    }
}
