package org.example.dp;

import java.util.*;

public class Q15663 {
    public static List<Integer> arr = new ArrayList<>();
    public static int[] ans;
    public static int N, M, last;
    public static Set<Integer> map = new HashSet<>();

    public static boolean[] visited;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();
        ans = new int[M];

        String str = scan.nextLine();
        String[] strArr = str.split(" ");

        for (String s : strArr) {
            arr.add(Integer.parseInt(s));
        }

        Collections.sort(arr);

        visited = new boolean[arr.size()];



        dfs(0);

    }

    public static void dfs(int depth) {
        if(depth==M){
            for(int i =0;i<M;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }

        last = -1;

        for(int i=0;i<arr.size();i++){
            if(!visited[i]&&(last == -1 || last != arr.get(i))) {
                ans[depth] = arr.get(i);

                visited[i] = true;

                dfs(depth + 1);
                visited[i] = false;
                last = arr.get(i);
            }
        }
    }
}

