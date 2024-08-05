package org.example.dfsNbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N 퀸
 * */
public class Q9663 {

    static int[] arr; // 퀸의 위치를 저장하는 배열
    static int N; // 체스판의 크기 (퀸의 수)
    static int de = 0; // 가능한 배치의 수를 저장하는 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 사용자로부터 N을 입력받음

        N = Integer.parseInt(str);

        arr = new int[N]; // 퀸의 위치를 저장할 배열 생성

        dfs(0);
        System.out.println(de);
    }
    public static void dfs(int depth) {

        if(depth==N){
            de++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col) {

        for(int i = 0 ; i < col ; i++) {
            if(arr[col]==arr[i]){
                return false;
            }
            if(Math.abs(arr[col]-arr[i])==Math.abs(col-i)){
                return false;
            }
        }

        return true;
    }
}
