package org.example.dfsNbfs;

import java.util.*;

public class Q13913 {

    static int[] parent;
    static int su;
    static int dong;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        su = scanner.nextInt();
        dong = scanner.nextInt();

        parent = new int[100001];
        Arrays.fill(parent, -1);

        int time = bfs();

        System.out.println(time);

        printPath();
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(su);
        int[] timeTaken = new int[100001];
        Arrays.fill(timeTaken, -1);
        timeTaken[su] = 0;

        while (!queue.isEmpty()) {
            int curPos = queue.poll();

            if (curPos == dong)
                return timeTaken[curPos];;

            if (curPos * 2 <= 100000 && parent[curPos * 2] == -1) {
                parent[curPos * 2] = curPos;
                timeTaken[curPos * 2] = timeTaken[curPos] + 1;
                queue.offer(curPos * 2);
            }
            if (curPos + 1 <= 100000 && parent[curPos + 1] == -1) {
                parent[curPos + 1] = curPos;
                timeTaken[curPos +1] = timeTaken[curPos] + 1;
                queue.offer(curPos + 1);
            }
            if (curPos - 1 >= 0 && parent[curPos - 1] == -1) {
                parent[curPos - 1] = curPos;
                timeTaken[curPos -1] = timeTaken[curPos] + 1;
                queue.offer(curPos - 1);
            }
        }
        return -1;
    }

    static void printPath() {
        Stack<Integer> path = new Stack<>();
        int idx = dong;

        while (idx != su) {
            path.push(idx);
            idx = parent[idx];
        }
        path.push(su);

        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
