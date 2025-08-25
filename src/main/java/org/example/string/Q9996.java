package org.example.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Q9996 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        String pattern = scan.nextLine();

        pattern = pattern.replace("*",".*");

        Pattern p = Pattern.compile("^"+pattern+"$");

        for(int i=0;i<t;i++){
            String s = scan.nextLine();
            System.out.println(p.matcher(s).matches() ? "DA":"NE");
        }

    }
}
