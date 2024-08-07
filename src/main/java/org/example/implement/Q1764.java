package org.example.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> unListen = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();
        for(int i=0;i<N;i++){
            unListen.put(br.readLine(),1);
        }

        for(int i=0;i<M;i++){
            String temp = br.readLine();
            unListen.put(temp,unListen.getOrDefault(temp,0)+1);
            if(unListen.get(temp)==2) results.add(temp);
        }


        Collections.sort(results);

        System.out.println(results.size());
        for(int i=0;i< results.size();i++){
            System.out.println(results.get(i));
        }

    }
}