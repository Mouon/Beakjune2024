package org.example.listNArray;

import java.util.Arrays;
import java.util.Scanner;

public class Q1015 {

    static int N;
    static int[] A,P,B;

    static Boolean[] visited;
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        A = new int[N];
        B = new int[N];
        P = new int[N];
        visited = new Boolean[N];

        for (int i=0;i<N;i++){
            A[i] = scan.nextInt();
            B[i] = A[i];
            visited[i] = false;
        }

        sort();

        solve();

    }


    static void sort(){

        Arrays.sort(B);

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(A[i]==B[j] && !visited[j]){
                    P[i]=j;
                    visited[j]= true;
                    break;
                }
            }
        }
    }

    static void solve(){
        for (int i=0;i<N;i++){
            System.out.print(P[i]+" ");
        }
    }

}
