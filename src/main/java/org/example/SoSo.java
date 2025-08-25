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


    static int N, L;
    static String S;

    public static int solution2(String[] strs) {
        N = strs.length;
        int ret = 0;
        for (String str : strs) {
            S = str;
            L = str.length();
            if (dfs(0))
                ret++;
        }

        return ret;
    }

    private static boolean dfs(int idx) {
        if (idx == L)
            return true;

        for (int i = idx + 1; i <= L; i++) {
            String subS = S.substring(idx, i);
            if (isValid(subS))
                if (dfs(i))
                    return true;
        }

        return false;
    }

    private static boolean isValid(String str) {
        return str.matches("AAB+") || str.matches("BAB+A");
    }

    public static void main(String[] args) {

        SoSo sol = new SoSo();

        String[] strs1 = {"AABAAA", "BAVV", "BABBAAAB", "BABAAABAABBABBA"};
        String[] strs2 = {"AA", "BAB", "BAAAA", "ABBAAB", "AABBBBABBAAAA"};
        String[] strs3 = {"AABAABAAB", "AABBBBAABBB", "AABBBABBABABBBAAABBBABBBA"};

        System.out.println(sol.solution(strs1)); // 2
        System.out.println(sol.solution(strs2)); // 0
        System.out.println(sol.solution(strs3)); // 3

        System.out.println();

        System.out.println(sol.solution2(strs1)); // 2
        System.out.println(sol.solution2(strs2)); // 0
        System.out.println(sol.solution2(strs3)); // 3
    }
}
