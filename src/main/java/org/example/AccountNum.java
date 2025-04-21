package org.example;

import java.util.*;

/**
 * 규칙 1) 계좌번호는 0 ~ 9 사이의 숫자와 특수문자 -로만 이루어집니다.
 * 규칙 2) 계좌번호에 포함된 숫자의 개수는 11개 이상 14개 이하입니다.
 * 규칙 3) 계좌번호에 포함된 -의 개수는 0개 이상 3개 이하입니다.
 * 규칙 4) 계좌번호에 포함된 -는 연속해서 나타날 수 없고, 계좌번호의 처음이나 마지막 자리에 나타날 수 없습니다.
 * */

// 계좌번호에 포함된 숫자와 -의 개수가 모두 같고, -의 위치가 같다면 같은 은행의 계좌번호입니다.

public class AccountNum {
    public static void main(String[] args) {
        String[] nums = {"1-2-3-456789012","582845-385823","48572-39485-89012","4-5-2-593328484","4958-392945123-","49582039415423","7-3-7-000000000","485723-693812","39482746582734","1-1-1-111111111","A4944-5095-4951","4851293412223"};
//        List<String> valid = filterValidAccounts(nums); // 디버깅 yong


        int[] ans = solution(nums);
        for(int num: ans){
            System.out.println(num);
        }
    }

    public static int[] solution(String[] nums) {
        List<String> validAccounts = filterValidAccounts(nums);
        Map<String, Integer> countMap = new HashMap<>();

        bankIdentifier(validAccounts, countMap);

        List<Integer> result = new ArrayList<>(countMap.values());
        result.sort((a, b) -> b - a);

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 은핵식별기
    private static void bankIdentifier(List<String> validAccounts, Map<String, Integer> countMap) {
        for (String account : validAccounts) {
            List<Integer> digitGroup = new ArrayList<>();
            int count = 0;

            // 은행 키 제작
            for (char c : account.toCharArray()) {
                if (Character.isDigit(c)) {
                    count++;
                } else if (c == '-') {
                    digitGroup.add(count); // 숫자 그룹 하나 끝났으므로 저장
                    count = 0; // 다음 숫자 그룹 시작
                }
            }
            digitGroup.add(count); // 마지막 숫자 그룹 추가

            // 키는 약간 하이픈기준 숫자갯수...
            String key = digitGroup.toString();

            // 키 기반 추가하기
            countMap.put( key, countMap.getOrDefault(key, 0) + 1);
        }
    }


    private static List<String> filterValidAccounts(String[] nums) {
        List<String> valid = new ArrayList<>();

        for (String num : nums) {
            if (!num.matches("[0-9\\-]+")) continue;

            if (num.startsWith("-") || num.endsWith("-")) continue; // 계좌번호의 처음이나 마지막 자리에 나타날 수 없습니다.
            if (num.contains("--")) continue;// 계좌번호에 포함된 -는 연속해서 나타날 수 없고 .. "---"이것도 해야하는지.. 우선 모르겠고..

            int numCount = 0; //숫자갯수
            int hyphenCoun = 0; //하이픈갯수
            for (char c : num.toCharArray()) {
                if (Character.isDigit(c)) numCount++;
                else if (c == '-') hyphenCoun++;
            }

            if (numCount < 11 || numCount > 14) continue; // 계좌번호에 포함된 숫자의 개수는 11개 이상 14개 이하입니다.
            if (hyphenCoun > 3||hyphenCoun < 0) continue; // 계좌번호에 포함된 -의 개수는 0개 이상 3개 이하입니다.

            valid.add(num);
        }

        return valid;
    }




}
