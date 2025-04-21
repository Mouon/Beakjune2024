package org.example.stackQ;
import java.util.*;

/**
 * 지피티 힌트 보면서 품
 * */

public class Process {
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            int[] tmp = {priorities[i],i};
            queue.add(tmp);
        }


        // 학습해볼 부분이다....
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            boolean hasHigherPriority = false;
            for (int[] q : queue) {
                if (q[0] > current[0]) { // 우선순위 높은게 있는지 비교하자
                    hasHigherPriority = true;
                    break;
                }
            }
            if (hasHigherPriority) { // 우선 순위 높았던게 있으면 다시 넣자
                queue.add(current);
            } else {
                answer++; // 꺼냈다가 다시 넣었으면 숫자 증가해지!
                if (current[1] == location) {
                    return answer;
                }
            }
        }


        return answer;
    }
}