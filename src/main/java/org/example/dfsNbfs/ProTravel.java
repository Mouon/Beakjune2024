package org.example.dfsNbfs;

import java.util.*;

public class ProTravel {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        Solution solution = new ProTravel().new Solution();
        String[] result = solution.solution(tickets);

        // 결과 출력
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    class Solution {
        boolean[] visited;
        ArrayList<String> routes;
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            visited = new boolean[tickets.length];
            routes = new ArrayList<>();

            dfs("ICN","ICN",tickets,0);

            Collections.sort(routes);
            answer = routes.get(0).split(" ");

            return answer;

        }

        public void dfs(String start, String route, String[][] tickets, int cnt){
            if(cnt == tickets.length){
                routes.add(route);
                return;
            }

            for(int i=0; i<tickets.length; i++){
                if(start.equals(tickets[i][0]) && !visited[i]){
                    visited[i] = true;
                    dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}
