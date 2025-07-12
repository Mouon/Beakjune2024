package org.example.hash;

import java.util.Arrays;
import java.util.Scanner;

/** 누적합을 이용 */
public class Q2143 {
    static Long T;
    static int n,m;
    static int[] A, B;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        T = scan.nextLong();

        n = scan.nextInt();
        A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = scan.nextInt();
        }

        m = scan.nextInt();
        B = new int[m];

        for(int i=0;i<m;i++){
            B[i] = scan.nextInt();
        }

        for(int i=1;i<n;i++){
            A[i] += A[i-1];
        }

        for(int i=1;i<m;i++){
            B[i] += B[i-1];
        }

        int aSize = n*(n+1)/2;
        int bSize = m*(m+1)/2;

        long[] aSum = new long[aSize];
        int idx=0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int av = A[j];
                if(i>0) av -= A[i-1];
                aSum[idx++] = av;
            }
        }

        long[] bSum = new long[bSize];
        idx=0;
        for(int i=0; i<m; i++) {
            for(int j=i; j<m; j++) {
                int bv = B[j];
                if(i>0) bv -= B[i-1];
                bSum[idx++] = bv;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0;
        int right = bSize - 1;
        long count = 0;

        while (left<aSize && right>-1){
            long asv = aSum[left], bsv = bSum[right];
            long sum = asv + bsv;
            if(sum==T){
                long ac = 0, bc = 0;
                while (left<aSize && asv == aSum[left]){
                    left++;
                    ac++;
                }

                while (right>-1 && bsv == bSum[right]){
                    right--;
                    bc++;
                }
                count += ac*bc;
            }
            if(sum>T){
                right--;
            }else if(sum<T){
                left++;
            }
        }
        System.out.print(count);
    }
}
