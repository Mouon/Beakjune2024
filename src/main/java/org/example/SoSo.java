package org.example;

import java.util.regex.Pattern;

// (AA) + (B)
// (BA) + (B+) + (A)
public class SoSo {
    public int solution(String[] strs){
        Pattern p = Pattern.compile("^(AAB+|BAB+A)+$");
        int answer = 0;
        for(String s : strs){
            if(p.matcher(s).matches()){
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

        SoSo sol = new SoSo();

        String[] strs1 = {"AABAAA", "BAVV", "BABBAAAB", "BABAAABAABBABBA"};
        String[] strs2 = {"AA", "BAB", "BAAAA", "ABBAAB", "AABBBBABBAAAA"};
        String[] strs3 = {"AABAABAAB", "AABBBBAABBB", "AABBBABBABABBBAAABBBABBBA"};

        System.out.println(sol.solution(strs1)); // 2
        System.out.println(sol.solution(strs2)); // 0
        System.out.println(sol.solution(strs3)); // 3
    }
}
