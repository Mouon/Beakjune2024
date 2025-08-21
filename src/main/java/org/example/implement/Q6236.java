package org.example.implement;

import java.util.Arrays;
import java.util.Scanner;
// 진짜 뭐가 틀린거임
public class Q6236 {
    static int m,n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        m = scan.nextInt();
        n = scan.nextInt();

        arr = new int[m];
        int max = 0;

        for(int i=0;i<m;i++){
            arr[i] = scan.nextInt();
            max = Math.max(max, arr[i]);
        }

        int right = Arrays.stream(arr).sum();;
        int left = max;

        int ans = max;
        while (left<=right){
            int mid = (left+right)/2;
            int count = 1;
            int remain = mid;

            for (int i=0;i<m;i++){
                if (remain < arr[i]) {
                    count++;
                    remain = mid;
                }
                remain -= arr[i];
            }

            if(count>n){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }

        }

        System.out.print(ans);



    }
}
