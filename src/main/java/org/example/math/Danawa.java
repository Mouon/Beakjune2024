package org.example.math;

public class Danawa {
    public static int solution(int p, int index){
        StringBuilder sb = new StringBuilder();

        for(int i=0;sb.length()<=index;i++){
            sb.append(Integer.toString(i,p));
        }

        char c = sb.charAt(index-1);
        return Character.getNumericValue(c);
    }

    public static void main(String[] args) {
        System.out.println(solution(10,15));
        System.out.println(solution(6,20));
        System.out.println(solution(2,16));

    }
}
