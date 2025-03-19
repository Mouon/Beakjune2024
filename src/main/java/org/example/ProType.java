package org.example;

import java.util.*;

public class ProType {

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            Map<String , Integer> type = new HashMap<>();

            type.putIfAbsent("R",0);
            type.putIfAbsent("T",0);
            type.putIfAbsent("C",0);
            type.putIfAbsent("F",0);
            type.putIfAbsent("J",0);
            type.putIfAbsent("M",0);
            type.putIfAbsent("A",0);
            type.putIfAbsent("N",0);

            for(int i=0;i<survey.length;i++){
                String str[] = survey[i].split("");
                String negative = str[0];
                String positive = str[1];

                if(choices[i]<4){
                    type.put(negative,type.get(negative)+(4-choices[i]));
                }else if(choices[i]>4){
                    type.put(positive,type.get(positive)+(choices[i]-4));
                }
            }

            if(type.get("R")>=type.get("T")){
                answer = answer+"R";
            }else{
                answer = answer+"T";
            }

            if(type.get("C")>=type.get("F")){
                answer = answer+"C";
            }else{
                answer = answer+"F";
            }

            if(type.get("J")>=type.get("M")){
                answer = answer+"J";
            }else{
                answer = answer+"M";
            }

            if(type.get("A")>=type.get("N")){
                answer = answer+"A";
            }else{
                answer = answer+"N";
            }



            return answer;
        }
    }
}
