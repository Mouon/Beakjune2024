package org.example.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q15666 {
    public static int[] arr;
    public static int N, M;
    public static int[] isThere;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();

        String str = scan.nextLine();
        String[] strArr = str.split(" ");
        String[] distinct = Arrays.stream(strArr)
                .distinct()
                .toArray(String[] :: new);

        visited = new boolean[N];
        isThere = new int[N];
        arr = new int[M];


        for (int i = 0; i < N; i++) {
            isThere[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(isThere);

        dfs(0,0);

    }

    /** K만큼 채운 후에 출력
     * depth가 약간 한 값 고정시키고 바꾸는 값이라고 생각하면 됨*/
    public static void dfs(int depth, int start) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int lastUsed=-1;
        for(int i=start;i<N;i++){
            if(!visited[i]&& (lastUsed == -1 || lastUsed != isThere[i])){
                arr[depth] = isThere[i]; /** 숫자 선택 */
                dfs(depth+1,i); /** 다음깊이에서 숫자 선택하세요 그니까 다음 위치의 숫자 선택 */
                lastUsed = isThere[i];
            }
        }

    }
}
