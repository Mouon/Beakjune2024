package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 블로그 봐야겠다 !!!!
 * */
public class Q1915 {
    static int n,m;
    static int[][] index;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        index = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                index[i][j] = line.charAt(j-1) - '0';
            }
        }

        int[][] psum = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1]
                        - psum[i - 1][j - 1] + index[i][j];
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(index[i][j] == 1){
                    int res = 1;
                    int idx = 1;

                    while (i+idx <= n && j + idx <=m){
                        int space = psum[i + idx][j + idx] - psum[i + idx][j - 1]
                                - psum[i - 1][j + idx]
                                + psum[i - 1][j - 1];

                        idx++;

                        if (space != (idx)*(idx)) break;

                        res = idx * idx;
                    }

                    ans = Math.max(ans,res);
                }

            }
        }

        System.out.print(ans);

    }
}
