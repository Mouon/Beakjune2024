package org.example.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q15663 {
    public static int[] arr;
    public static int N, M;
    public static int[] isThere;


    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();

        String str = scan.nextLine();
        String[] strArr = str.split(" ");
        String[] distinct = Arrays.stream(strArr)
                .distinct()
                .toArray(String[] :: new);

        visited = new boolean[N];
        isThere = new int[N];
        arr = new int[M];


        for (int i = 0; i < N; i++) {
                isThere[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(isThere);

        dfs(0);

    }

    /** K만큼 채운 후에 출력
     * depth가 약간 한 값 고정시키고 바꾸는 값이라고 생각하면 됨*/
    public static void dfs(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int lastUsed=-1;

        for(int i=0;i<N;i++){
            if(!visited[i]&& (lastUsed == -1 || lastUsed != isThere[i])){
                visited[i]=true;
                arr[depth] = isThere[i]; /** 숫자 선택 */
                dfs(depth+1); /** 다음깊이에서 숫자 선택하세요 그니까 다음 위치의 숫자 선택 */
                visited[i]=false;
                lastUsed = isThere[i];
            }
        }

    }
}


/**
 *
 * 1. **입력값 처리:**
 *    입력 배열은 `9, 7, 9, 1`입니다. 이를 정렬하면 `1, 7, 9, 9`이 됩니다.
 *
 * 2. **DFS 호출:**
 *    `dfs(0)`을 호출하면서 시작합니다. 여기서 `depth`는 현재 선택한 숫자의 위치를 나타냅니다.
 *
 * 3. **첫 번째 깊이 (depth = 0):**
 *    - `lastUsed = -1`로 초기화됩니다.
 *    - 루프 시작 (`i = 0`):
 *      - `isThere[0] = 1`이고, 아직 방문되지 않았으므로 `visited[0] = true`로 설정하고, `arr[0] = 1`로 설정합니다.
 *      - `dfs(1)` 호출.
 *
 * 4. **두 번째 깊이 (depth = 1):**
 *    - `lastUsed = -1`로 초기화됩니다.
 *    - 루프 시작 (`i = 0`):
 *      - `isThere[0] = 1`은 이미 방문된 상태 (`visited[0] = true`), 따라서 건너뜁니다.
 *    - 루프 (`i = 1`):
 *      - `isThere[1] = 7`이고, 아직 방문되지 않았으므로 `visited[1] = true`로 설정하고, `arr[1] = 7`로 설정합니다.
 *      - `dfs(2)` 호출.
 *
 * 5. **결과 출력 (depth = 2):**
 *    - `depth`가 `M`에 도달했으므로 배열 `arr = {1, 7}`를 출력합니다: `1 7`
 *    - `visited[1] = false`로 설정하고, `lastUsed = 7`로 설정합니다.
 *    - 루프 (`i = 2`):
 *      - `isThere[2] = 9`이고, 아직 방문되지 않았으므로 `visited[2] = true`로 설정하고, `arr[1] = 9`로 설정합니다.
 *      - `dfs(2)` 호출.
 *
 * 6. **결과 출력 (depth = 2):**
 *    - `depth`가 `M`에 도달했으므로 배열 `arr = {1, 9}`를 출력합니다: `1 9`
 *    - `visited[2] = false`로 설정하고, `lastUsed = 9`로 설정합니다.
 *    - 루프 (`i = 3`):
 *      - `isThere[3] = 9`이고, `lastUsed = 9`이므로 건너뜁니다.
 *    - `visited[0] = false`로 설정하고, `lastUsed = 1`로 설정합니다.
 *
 * 7. **첫 번째 깊이 (계속, depth = 0):**
 *    - 루프 (`i = 1`):
 *      - `isThere[1] = 7`이고, 아직 방문되지 않았으므로 `visited[1] = true`로 설정하고, `arr[0] = 7`로 설정합니다.
 *      - `dfs(1)` 호출.
 *
 * 8. **두 번째 깊이 (계속, depth = 1):**
 *    - `lastUsed = -1`로 초기화됩니다.
 *    - 루프 시작 (`i = 0`):
 *      - `isThere[0] = 1`이고, 아직 방문되지 않았으므로 `visited[0] = true`로 설정하고, `arr[1] = 1`로 설정합니다.
 *      - `dfs(2)` 호출.
 *
 * 9. **결과 출력 (depth = 2):**
 *    - `depth`가 `M`에 도달했으므로 배열 `arr = {7, 1}`를 출력합니다: `7 1`
 *    - `visited[0] = false`로 설정하고, `lastUsed = 1`로 설정합니다.
 *    - 루프 (`i = 1`):
 *      - `isThere[1] = 7`은 이미 방문된 상태 (`visited[1] = true`), 따라서 건너뜁니다.
 *    - 루프 (`i = 2`):
 *      - `isThere[2] = 9`이고, 아직 방문되지 않았으므로 `visited[2] = true`로 설정하고, `arr[1] = 9`로 설정합니다.
 *      - `dfs(2)` 호출.
 *
 * 10. **결과 출력 (depth = 2):**
 *     - `depth`가 `M`에 도달했으므로 배열 `arr = {7, 9}`를 출력합니다: `7 9`
 *     - `visited[2] = false`로 설정하고, `lastUsed = 9`로 설정합니다.
 *     - 루프 (`i = 3`):
 *       - `isThere[3] = 9`이고, `lastUsed = 9`이므로 건너뜁니다.
 *     - `visited[1] = false`로 설정하고, `lastUsed = 7`로 설정합니다.
 *
 *
 * */