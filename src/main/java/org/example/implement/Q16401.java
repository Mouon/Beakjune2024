package org.example.implement;

import java.util.Scanner;

public class Q16401 {
    static int n,m;
    static Long[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        arr = new Long[m];

        long max = 0;
        for(int i=0;i<m;i++){
            arr[i] = scan.nextLong();
            max = Math.max(max,arr[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;


        while (left<=right){
            long mid = (left+right)/2;
            long count = 0;

            for (int i = 0; i < m; i++) {
                count += arr[i] / mid;
            }

            if(count>=n){
                left = mid + 1;
                ans = mid;
            }else {
                right = mid - 1;
            }
        }

        System.out.print(ans);

    }
}
