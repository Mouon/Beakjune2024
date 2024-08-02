package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {

    static ArrayList<Integer> list[];
    static  boolean[] isVisit;
    static  int [] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N+1];

        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=0;i<N;i++){
            System.out.println(parent[i]);
        }

    }

    public static void dfs(int index){
        isVisit[index]=true;
        for(int i:list[index]){
            if(!isVisit[i]){
                parent[i]=index;
                dfs(i);
            }
        }


    }



}
