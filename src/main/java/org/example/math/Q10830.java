package org.example.math;

import java.io.IOException;
import java.util.Scanner;

public class Q10830 {

    static int MOD = 1000;
    static int N;
    static long B;
    static int[][] result;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        B = scan.nextLong();

        int[][] A = new int[N][N];
        result = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                A[i][j]=scan.nextInt();
            }
        }

        int[][] result = power(A, B);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    static int[][] power(int[][] A, long exp) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiply(result, A); /** 짝수 한개 소진 */
            }
            A = multiply(A, A);
            exp /= 2;
        }
        return result;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for(int k=0;k<N;k++){
                    temp[i][j]= ( temp[i][j] + A[i][k]*B[k][j] )%MOD;
                }
            }
        }
        return temp;
    }
}
