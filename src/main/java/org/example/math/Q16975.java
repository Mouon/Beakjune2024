package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 몰라서 블로그 볼거임!
// 아 플레였음! 알았으면 안푸는건데
// tree[i] → arr[i - lowbit(i) + 1] ~ arr[i]

public class Q16975 {
    static long[] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new long[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken());
        int now;

        add(1, prev);

        // diff 만들기
        for(int i=2; i<=n; i++) {
            now = Integer.parseInt(st.nextToken());
            add(i, now - prev);
            prev = now;
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if(op == 1) {
                int b = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                // 예시
                // diff[3] += 10
                // diff[6] -= 10
                add(a, k);
                add(b+1, -k);
            }else {
                sb.append(sum(a)+"\n");
            }

        }

        System.out.println(sb);

    }


    /**
     * arr[pos]에 val을 더하고,
     * 그 값이 포함되는 상위 구간(tree 배열)에 반영되도록
     * 해당되는 모든 tree 노드를 갱신하는 역할
     * */
    static void add(int pos, int val) {
        while(pos <= n) {
            tree[pos] += val;
            pos += (pos&-pos);
        }
    }

    // 차분 배열을 더해서 답구함
    static long sum(int pos) {
        long result = 0;
        while(pos > 0) {
            result += tree[pos];
            pos &= (pos-1);
        }
        return result;

    }

}
