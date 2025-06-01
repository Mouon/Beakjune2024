package org.example;

import java.io.*;

public class Q9252 {
    static int[][] dp = new int[1001][1001];
    static String[] n1;
    static String[] n2;
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n1 = br.readLine().split("");
        n2 = br.readLine().split("");

        String ans = solve();

        if(!ans.isEmpty()){
            System.out.println(ans.length());
            System.out.println(ans);
        }else {
            System.out.println(0);
        }


    }

    public static String solve(){
        for(int i=0;i<n1.length;i++){
            for (int j=0;j< n2.length;j++){
                if(n1[i].equals(n2[j])){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        int x = n1.length;
        int y = n2.length;
        String a = "";
        while (x != 0 && y != 0) {
            if (n1[x - 1].equals(n2[y - 1])) {
                a += n1[x - 1];
                x -= 1;
                y -= 1;
            } else if (dp[x - 1][y] > dp[x][y - 1]) {
                x -= 1;
            } else {
                y -= 1;
            }
        }

        String ans = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            ans += a.charAt(i);
        }
        return ans;

    }
}
