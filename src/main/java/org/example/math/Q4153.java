package org.example.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q4153 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nav = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        int i=0;
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double A = Math.pow(Long.parseLong(st.nextToken()),2);
            double B = Math.pow(Long.parseLong(st.nextToken()),2);
            double C = Math.pow(Long.parseLong(st.nextToken()),2);
            if(A==0&&B==0&&C==0){
                break;
            }
            nav.add((int)A);
            nav.add((int)B);
            nav.add((int)C);

            Collections.sort(nav);

            if(nav.get(2)== nav.get(1)+nav.get(0)){
                ans.add("right");
            }else{
                ans.add("wrong");
            }
//            System.out.println(nav.get(1)+nav.get(0));
//            System.out.println(nav.get(0)+" "+nav.get(1)+" "+nav.get(2));
            nav.clear();


        }



        for(String j : ans){
            System.out.println(j);
        }

    }

}
