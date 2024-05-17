package org.example.implement;

import java.util.Arrays;
import java.util.Scanner;

public class Q10988 {
    public static void main(String[] args) throws Exception {

        Scanner scan =new Scanner(System.in);
        String str = scan.nextLine();
        int ans=1;
        String[] arr=str.split("");
        int isObb=arr.length/2;
            for(int i=0;i<isObb;i++){
                if(!arr[i].equals(arr[arr.length-i-1])){
                    ans=0;
                }
            }
            System.out.println(ans);



    }
}
