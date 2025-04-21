package org.example.hash;

import java.util.*;

public class BestAlbum {
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String,Integer > genresMap = new HashMap<>();
        HashMap<String,Integer > genresMap2 = new HashMap<>();
        HashMap<Integer,Integer> playsMap = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<genres.length;i++){
            playsMap.put(i, plays[i]);
        }


        // 해시 정렬은 외우자
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(playsMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue())){
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry : entryList){
            genresMap2.put(genres[entry.getKey()],genresMap2.getOrDefault(genres[entry.getKey()],0)+entry.getValue());
        }

        List<Map.Entry<String, Integer>> entryList2 = new LinkedList<>(genresMap2.entrySet());
        entryList2.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String,Integer> entry : entryList2){
            System.out.println("key2 : " + entry.getKey() + ", value2 : " + entry.getValue());
        }

        for(Map.Entry<String,Integer> entry2 : entryList2){
            for(Map.Entry<Integer,Integer> entry : entryList){
                if(entry2.getKey().equals(genres[entry.getKey()])){
                    genresMap.put(genres[entry.getKey()],genresMap.getOrDefault(genres[entry.getKey()],0)+1);
                    if(genresMap.getOrDefault(genres[entry.getKey()],0)<=2){
                        System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue()+", count : "+genresMap.getOrDefault(genres[entry.getKey()],0));
                        arr.add(entry.getKey());
                    }
                }
            }
        }

        int[] answer = new int[arr.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}