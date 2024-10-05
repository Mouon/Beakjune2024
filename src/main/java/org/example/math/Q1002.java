package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 원방이다
 * */
public class Q1002 {

    static int T;
    static int x1,x2,y1,y2,r1,r2;
    static int centerDistance ;
    static int[] result ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        T = Integer.parseInt(br.readLine());

        result = new int[T];

        for (int i =0; i<T;i++){
            st = new StringTokenizer(br.readLine());

            x1= Integer.parseInt(st.nextToken());
            y1= Integer.parseInt(st.nextToken());
            r1= Integer.parseInt(st.nextToken());
            x2= Integer.parseInt(st.nextToken());
            y2= Integer.parseInt(st.nextToken());
            r2= Integer.parseInt(st.nextToken());

            int rDistance2 =(int) Math.pow(r1-r2,2);
            int rDistance =(int)Math.pow(r1+r2,2);

            centerDistance = (int)(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));

            if(centerDistance==0){
                if(r1==r2){
                    result[i]=-1;
                } else {
                    result[i]=0;
                }
            } else{
                if(centerDistance > rDistance || centerDistance < rDistance2){
                    result[i]=0;
                } else if(centerDistance == rDistance || centerDistance==rDistance2){
                    result[i]=1;
                }else{
                    result[i]=2;
                }
            }

        }

        for (int i =0; i<T;i++){
            System.out.println(result[i]);
        }

    }

}

