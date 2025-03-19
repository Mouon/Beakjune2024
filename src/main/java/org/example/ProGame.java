package org.example;
import java.util.*;

public class ProGame {
    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            Map<String,Integer> giftGage = new HashMap<>();
            Map<String,Integer> sendGage = new HashMap<>();
            Map<String,Integer> receiveGage = new HashMap<>();
            Map<String,Integer> ans = new HashMap<>();
            Map<String,Map<String,Integer>> history = new HashMap<>();

            for(String name : friends){
                giftGage.put(name,0);
                receiveGage.put(name,0);
                sendGage.put(name,0);
                ans.put(name,0);
                history.put(name,new HashMap<>());

            }

            for(String his : gifts){
                String[] str = his.split(" ");
                String sender = str[0];
                String receiver = str[1];

                receiveGage.put(receiver,receiveGage.getOrDefault(receiver,0)+1);
                sendGage.put(sender,sendGage.get(sender)+1);
                history.get(sender).put(receiver,history.get(sender).getOrDefault(receiver,0)+1);
            }

            for(String name : friends){
                giftGage.put(name,sendGage.getOrDefault(name,0)-receiveGage.getOrDefault(name,0));
            }

            for(String me : friends){
                for(String friend : friends){
                    if(!me.equals(friend)){
                        if(history.get(me).getOrDefault(friend,0)>0||history.get(friend).getOrDefault(me,0)>0){
                            if(history.get(me).getOrDefault(friend,0)>history.get(friend).getOrDefault(me,0)){
                                ans.put(me,ans.get(me)+1);
                            }else if (history.get(me).getOrDefault(friend,0) == history.get(friend).getOrDefault(me,0)){
                                if(giftGage.getOrDefault(friend,0)<giftGage.getOrDefault(me,0)){
                                    ans.put(me,ans.get(me)+1);
                                }
                            }
                        }else{
                            if(giftGage.getOrDefault(friend,0)<giftGage.getOrDefault(me,0)){
                                ans.put(me,ans.get(me)+1);
                            }
                        }
                    }
                }
            }

            ArrayList<Integer> arr = new ArrayList<>();

            for (String name : friends) {
                answer = Math.max(answer, ans.get(name));
            }

            return answer;
        }
    }
}
