package org.example.dfsNbfs;

import java.util.*;

// 우선 문제 뜻 이해못하는중
// 공부해보자
public class Q2251 {
    static int[] waters;
    static Set<Integer> ans = new TreeSet<>();
    static boolean[][] check;
    public static void main(String[] args) {

        waters = new int[3];

        Scanner scan = new Scanner(System.in);
        check = new boolean[201][201];

        for(int i=0;i<3;i++){
            waters[i] = scan.nextInt();
        }

        dfs(0,0,waters[2]);

        for(int num : ans) {
            System.out.print(num+" ");
        }

    }

    static void dfs(int a, int b, int c){
        if(check[a][b]) return;

        if(a==0){
            ans.add(c);
        }

        check[a][b] = true;

        if(a+b > waters[1]){
            dfs((a+b)-waters[1], waters[1], c);
        }else {
            dfs(0,a+b,c);
        }

        if(a+c > waters[2]){
            dfs((a+c)-waters[2], b, waters[2]);
        }else {
            dfs(0,b,a+c);
        }

        if(b+c > waters[2]){
            dfs(a,(b+c)-waters[2],waters[2]);
        }else {
            dfs(a,0,b+c);
        }

        if(a+b > waters[0]){
            dfs(waters[0], (a+b)-waters[0], c);
        }else {
            dfs(a+b,0,c);
        }

        if(a+c > waters[0]){
            dfs(waters[0],b,a+c-waters[0]);
        }else {
            dfs(a+c, b, 0);
        }

        if(b+c>waters[1]){
            dfs(a,waters[1], (b+c)-waters[1]);
        }else {
            dfs(a,b+c, 0);
        }
    }


}
