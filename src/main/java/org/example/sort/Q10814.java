package org.example.sort;

import java.util.*;

public class Q10814 {
    static List<Member> list = new ArrayList<>() ;
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();


        for (int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] temp = str.split(" ");
            int age = Integer.parseInt(temp[0]);
            String name = temp[1];
            Member member = new Member(age,name);
            list.add(member);
        }

        list.sort(Comparator.comparingInt(l->l.age));

        for (Member member : list) {
            System.out.println(member.age + " " + member.name);
        }

    }
}
class Member{
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

}

