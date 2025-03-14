package org.example.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q18870 {
    static int[] arr,temp;
    static HashMap<Integer,Integer> map;
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        arr = new int[N];
        temp = new int[N];
        map = new HashMap<>();

        for(int i=0;i<N;i++){
            arr[i] =  scan.nextInt();
            temp[i] = arr[i];
        }

        Arrays.sort(arr);

        int rank = 0;

        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,rank++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int k : temp){
            sb.append(map.get(k)).append(" ");
        }

        System.out.print(sb);

    }
}
