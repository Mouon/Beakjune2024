package org.example.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q15652 {


    public static int[] arr;
    public static int N, K;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();

        arr = new int[K];

        dfs(1,0);

    }

    /** K만큼 채운후에 출력
     * depth가 약간 한 값 고정시키고 바꾸는 값이라고 생각하면됨*/
    public static void dfs(int at, int depth) {

        if(depth==K){
            for (int i=0;i<K;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        /** 1부터 N까지 요소의 조합이니 N을 범위에 포함해야지! */
        for(int i = at;i<=N;i++){
            arr[depth] = i;
            dfs(i,depth+1); /** 배열의 다음요소는 지금 요소랑 중복되면 안되니까 i+1을 at 전달해서 그 뒤 요소의 조합을 찾으라고 탐색을 보냄 */
        }

    }
}
