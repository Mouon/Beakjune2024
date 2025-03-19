package org.example;
import java.util.*;

public class ProReport {
    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashMap<String, Set<String>> reportMap = new HashMap<>();//신고 내역 맵
            HashMap<String, Integer> reportedMap = new HashMap<>(); //신고횟수
            HashMap<String, Integer> IndexMap = new HashMap<>(); //인덱스랑 맵 매핑
            int[] answer = new int[id_list.length];

            for(int i=0;i<id_list.length;i++){
                IndexMap.put(id_list[i],i);
            }

            for(int i=0;i<report.length;i++){
                String[] str = report[i].split(" ");
                String reporter  = str[0];
                String reported  = str[1];

                reportMap.putIfAbsent(reporter, new HashSet<>());
                if(reportMap.get(reporter).add(reported)){
                    reportedMap.put(reported,reportedMap.getOrDefault(reported,0)+1);
                }
            }

            Set<String> banned = new HashSet<>();

            for(String rep : reportedMap.keySet()){
                if(reportedMap.getOrDefault(rep,0)>=k){
                    banned.add(rep);
                }
            }

            for(String rep : reportMap.keySet()){
                for(String ban: banned){
                    if(reportMap.get(rep).contains(ban)){
                        answer[IndexMap.get(rep)]++;
                    }
                }
            }




            return answer;
        }
    }

}
