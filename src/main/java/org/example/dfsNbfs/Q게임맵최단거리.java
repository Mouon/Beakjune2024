package org.example.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q게임맵최단거리 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[][] maps) {
            int answer = -1;

            Queue<int[]> queue = new LinkedList<>();

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            queue.offer(new int[]{0, 0, 1});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
                    answer = now[2];
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int curX = now[0] + dx[i];
                    int curY = now[1] + dy[i];

                    if (curX >= 0 && curY >= 0 && curX < maps.length && curY < maps[0].length && maps[curX][curX] != 0) {
                        queue.offer(new int[]{curX, curY, now[2]+ 1});
                        maps[curX][curY] = 0;
                    }
                }
            }
            return answer;
        }
    }
}

