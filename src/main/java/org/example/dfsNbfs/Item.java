package org.example.dfsNbfs;
import java.util.*;

public class Item {
    // 진짜 오래 고민했는데 그냥 각이 안나옴

// 교훈 :
// 테두리를 다루기위해 좌표를 두배한다.
// 그다음 경로를 위해 bfs를 하는데.. 좌표에 거리값을 저장한다.
// 가장 큰 교훈은 테두리를 다루는 조건문이다. OR 연산자로 고고했다.

    class Solution {
        static int[][] map;
        static int answer;

        static int[] dx= {-1, 0, 0, 1};
        static int[] dy= {0, -1, 1, 0};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            answer = 0;

            map= new int[101][101];

            for(int i=0; i<rectangle.length; i++){
                fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
            }

            bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);

            return answer/2;

        }
        // 속은 2, 겉은 1
        public void fill(int x1, int y1, int x2, int y2){
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if(map[i][j]==2) continue;
                    map[i][j]=2;
                    if(i==x1||i==x2||j==y1||j==y2){
                        map[i][j]=1;
                    }
                }
            }
        }


        public void bfs(int startX, int startY, int itemX, int itemY){
            boolean[][] visited = new boolean[101][101];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY});
            visited[startX][startY] = true; // 시작 지점 방문 처리

            while(!queue.isEmpty()){
                int[] arr = queue.poll();
                int x = arr[0];
                int y = arr[1];

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100){
                        // 테두리일때만 연산 들어감
                        if(map[nx][ny] == 1 && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            map[nx][ny] = map[x][y] + 1;


                            if(nx == itemX && ny == itemY){
                                answer = map[nx][ny];
                                return;
                            }
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }


    }
}
