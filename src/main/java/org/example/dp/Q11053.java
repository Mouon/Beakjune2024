package org.example.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q11053 {

    static int max[];
    static int arr[];
    static int N;
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        String[] tempArr=str.split(" ");
        arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        max=new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tempArr[i]);
        }

        // 초기 값 설정
        max[0] = 1;
        for (int i = 1; i < N; i++) {
            max[i] = 1;
        }

        cur(1);
        int lisLength = Arrays.stream(max).max().orElse(1);
        System.out.println(lisLength);

    }

    public static void cur(int K){
        if(N==K){
            return;
        }

        for(int i=0;i<K;i++){
            if(arr[K]>arr[i]&&max[K]<max[i]+1){
                max[K] = max[i] + 1; /** max 값을 계속 바꿈 */
            }
        }

        cur(K+1);

    }

}
