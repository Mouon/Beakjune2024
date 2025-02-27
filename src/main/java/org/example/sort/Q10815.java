package org.example.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q10815 {
    static int N,M;
    static int[] sang, cards,ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        sang = new int[N];

        for(int i=0;i<N;i++){
            sang[i] =  scan.nextInt();
        }

        Arrays.sort(sang);

        M = scan.nextInt();

        cards = new int[M];
        ans = new int[M];

        for(int i=0;i<M;i++){
            cards[i] =  scan.nextInt();
        }


        for (int i = 0; i < M; i++) {
            if (binarySearch(cards[i])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }

        for (int ans : ans){
            System.out.print(ans+" ");
        }

    }

    static boolean binarySearch(int target) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sang[mid] == target) {
                return true;
            } else if (sang[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
