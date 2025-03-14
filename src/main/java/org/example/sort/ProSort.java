package org.example.sort;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProSort {
    static class Solution {
        public String[] solution(String[] files) {
            Pattern pattern = Pattern.compile("(?<head>\\D+)(?<num>\\d+)(.*)");

            Arrays.sort(files, (f1, f2) -> {
                Matcher m1 = pattern.matcher(f1.toLowerCase());
                Matcher m2 = pattern.matcher(f2.toLowerCase());

                m1.find();
                m2.find();

                int headCompare = m1.group("head").compareTo(m2.group("head"));

                if(headCompare!=0){
                    return headCompare;
                }

                int n1 = Integer.parseInt(m1.group("num"));
                int n2 = Integer.parseInt(m2.group("num"));

                return Integer.compare(n1, n2);
            });

            return files;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] result = solution.solution(files);

        System.out.println("정렬 결과:");
        for (String file : result) {
            System.out.println(file);
        }
    }
}
