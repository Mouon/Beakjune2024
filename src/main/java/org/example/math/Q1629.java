package org.example.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(Cur(A,B,C));

    }

    public static long Cur (long base, long exponent, long mod){
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base%mod;
        }
        long temp = Cur(base,exponent/2,mod);
        if(exponent%2==0){
            return temp * temp % mod;
        }else{
            return temp * temp % mod*base%mod;
        }

    }


}
