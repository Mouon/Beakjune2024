package org.example.dfsNbfs;

import java.util.*;

public class Q9205 {
    static int T, N, goalX, goalY;
    static List<int[]> points;
    static Set<String> visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();

        for (int j = 0; j < T; j++) {
            N = scan.nextInt();
            points = new ArrayList<>();
            visited = new HashSet<>();

            int startX = scan.nextInt();
            int startY = scan.nextInt();
            points.add(new int[]{startX, startY});

            for (int i = 0; i < N; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                points.add(new int[]{x, y});
            }

            goalX = scan.nextInt();
            goalY = scan.nextInt();
            points.add(new int[]{goalX, goalY});

            if (bfs(startX, startY)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static boolean bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited.add(startX + "," + startY);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == goalX && y == goalY) return true;

            for (int[] point : points) {
                int nextX = point[0];
                int nextY = point[1];

                if (!visited.contains(nextX + "," + nextY) && getDistance(x, y, nextX, nextY) <= 1000) {
                    queue.add(new int[]{nextX, nextY});
                    visited.add(nextX + "," + nextY);
                }
            }
        }
        return false;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
