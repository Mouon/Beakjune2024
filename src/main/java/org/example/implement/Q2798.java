package org.example.implement;

import java.util.Scanner;

public class Q2798 {

    public static void main(String[] args) throws Exception {

        int temp=Integer.MAX_VALUE;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        int[] num = new int[N];

        str = scan.nextLine();
        String[] strNum = str.split(" ");

        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(strNum[i]);
        }

        for(int i=0;i<N-2;i++){
            for(int j=1;j<N-1-i;j++){
                for(int k=1+j;k<N-i;k++){
                    int sum = num[i]+num[i+j]+num[i+k];
                    if(K>=sum){
                    temp=Math.abs(K-temp)>Math.abs(K-sum)?sum:temp;
                    }
                }
            }
        }

        System.out.println(temp);


    }
}
