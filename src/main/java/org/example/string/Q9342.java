package org.example.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Q9342 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(A|B|C|E|F)*A+F+C+(A|B|C|E|F)*$");
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<t;i++){
            String str = scan.nextLine();
            System.out.println(p.matcher(str).matches() ? "Infected!":"Good");
        }
    }
}
