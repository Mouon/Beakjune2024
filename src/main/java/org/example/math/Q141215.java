package org.example.math;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q141215 {

    public static void main(String[] args)  throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] tri = str.split(" ");
        int[] numTri = new int[3];
        numTri[0] = Integer.parseInt(tri[0]);
        numTri[1] = Integer.parseInt(tri[1]);
        numTri[2] = Integer.parseInt(tri[2]);

        Arrays.sort(numTri);

        if(numTri[2]>=numTri[0]+numTri[1]){
            numTri[2]=numTri[0]+numTri[1]-1;
        }

        System.out.println(numTri[0]+numTri[1]+numTri[2]);

    }
}
