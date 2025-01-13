package org.example.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/** (a^(b/2) × a^(b/2)) mod C
 * (a^(b/2) × a^(b/2+1)) mod C
 */


public class Q1629 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(Cur(A,B,C));

    }

    // 플래그 포인트는 0, 1 이다.
    public static long Cur (long base, long exponent, long mod){
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base%mod;
        }
        long temp=Cur(base,exponent/2,mod);
        if(exponent%2==0){
            return (temp*temp)%mod;
        }else {
            return (temp*Cur(base,exponent/2+1,mod))%mod;
        }
    }
}
