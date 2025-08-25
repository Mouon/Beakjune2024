package org.example;

import java.util.*;

// 없어지는 칸도 방문노드 채크마냥 관리하기
public class SoSo1 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] removed;
    public int solution(int n, int m, int[][] order){
        int left = 1;
        int right = order.length-2;
        int answer = order.length-2;
        removed = new boolean[n][m];

        // 이분탐색
        while (right <= left) {
            int mid = (left + right) / 2;
            if (bfs(n, m, order, mid)) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean bfs(int n, int m, int[][] order, int k) {
        boolean[][] removed = getRemoved(order, k);

        if (removed[0][0] || removed[n-1][m-1]) return false;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;



        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            if (y == n - 1 && x == m - 1) return true;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= n || nx < 0 || ny >= m) continue;
                if (visited[ny][nx]) continue;
                if (removed[ny][nx]) continue;
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

        return false;
    }

    private static boolean[][] getRemoved(int[][] order, int k) {

        for (int i = 0; i < k; i++) {
            int y = order[i][0] - 1;
            int x = order[i][1] - 1;
            removed[y][x] = true;
        }
        return removed;
    }

    public static void main(String[] args) {
        SoSo1 sol = new SoSo1();
        int n = 3, m = 4;
        int[][] order = {
                {3,2},{3,1},{1,4},{1,2},{2,4},{2,3},{2,2},{1,3},{2,1},{3,3}
        };
        System.out.println(sol.solution(n, m, order)); // 예제: 6
    }
}
