package org.example.implement;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q15654 {

    public static int[] arr;
    public static int N, K;
    public static int[] isThere;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        scan.nextLine();

        String str = scan.nextLine();
        String[] strArr = str.split(" ");

        isThere = new int[N];
        arr = new int[K];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            isThere[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(isThere);

        dfs(0);

    }

    /** K만큼 채운 후에 출력
     * depth가 약간 한 값 고정시키고 바꾸는 값이라고 생각하면 됨*/
    public static void dfs(int depth) {

        if (depth == K) {
            for (int i = 0; i < K; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true; /** 현재깊이에서 선택한 숫자는 막아둠 */
                arr[depth] = isThere[i]; /** 숫자 선택 */
                dfs(depth+1); /** 다음깊이에서 숫자 선택하세요 그니까 다음 위치의 숫자 선택 */
                visited[i] = false;
            }
        }

    }
}
