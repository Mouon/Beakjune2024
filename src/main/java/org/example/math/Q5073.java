package org.example.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q5073 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nav = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        int i=0;
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double A = Long.parseLong(st.nextToken());
            double B = Long.parseLong(st.nextToken());
            double C = Long.parseLong(st.nextToken());
            if(A==0&&B==0&&C==0){
                break;
            }
            nav.add((int)A);
            nav.add((int)B);
            nav.add((int)C);

            Collections.sort(nav);
            if(nav.get(2)>= nav.get(0)+nav.get(1)){
                ans.add("Invalid");
            }else if(nav.get(1).equals(nav.get(0)) &&nav.get(1).equals(nav.get(2))&&nav.get(2).equals(nav.get(0))){
                ans.add("Equilateral");
            } else if(!nav.get(1).equals(nav.get(0))&&!nav.get(0).equals(nav.get(2))&&!nav.get(1).equals(nav.get(2))){
                ans.add("Scalene");
            }else{
                ans.add("Isosceles");
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
