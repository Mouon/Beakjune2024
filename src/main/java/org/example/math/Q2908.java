package org.example.math;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Q2908 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] num = str.split(" ");


        for(int i=0;i<2;i++) {
            int[] digits = Stream.of(String.valueOf(num[i]).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<int[]> list = Arrays.asList(digits);
            Collections.reverse(Collections.singletonList(list.get(0)));
            StringBuilder sb = new StringBuilder();
            for (int j=digits.length-1;j>=0;j--) {
                sb.append(digits[j]);
            }
            num[i] = sb.toString();
        }

        if(Integer.parseInt(num[0])>Integer.parseInt(num[1])){
            System.out.println(num[0]);
        }else{
            System.out.println(num[1]);
        }


    }
}
