package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11047 {
    static int coin[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] list = str.split(" ");
        int n = Integer.parseInt(list[0]);
        int k = Integer.parseInt(list[1]);
        int count=0;
        coin=new int[n];

        for(int i=0;i<n;i++){
            coin[i]=Integer.parseInt(br.readLine());
        }

        for(int i=n-1;i>=0;i--){
            if(k!=0){
                count+=k/coin[i];
                k=k%coin[i];
            }else {
                break;
            }
        }

        System.out.println(count);
    }
}
