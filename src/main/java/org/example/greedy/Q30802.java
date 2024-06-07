package org.example.greedy;

import java.io.IOException;
import java.util.Scanner;

public class Q30802 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        String str = scan.nextLine();
        String[] arr = str.split(" ");
        int[] many = new int[6];
        int T = scan.nextInt();
        int P = scan.nextInt();
        int sum=0;
        for(int i=0;i<6;i++){
            if(Integer.parseInt(arr[i])==0){
                many[i]=0;
            } else if(Integer.parseInt(arr[i])<T){
                many[i]=1;
            }else{
                many[i]=Integer.parseInt(arr[i])/T;
                if(Integer.parseInt(arr[i])%T!=0){
                    many[i]+=1;
                }
            }
            sum+=many[i];
        }

        System.out.println(sum);
        System.out.println(N/P+" "+N%P);

    }
}
