package org.example;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 1. 중복 제거
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // 2. 리스트로 변환
        List<Integer> list = new ArrayList<>(set);

        // 3. 짝수/홀수 인덱스 나눠 담기
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) even.add(list.get(i));
            else odd.add(list.get(i));
        }

        // 4. 정렬
        Collections.sort(even);                // 오름차순
        odd.sort(Collections.reverseOrder());  // 내림차순

        // 5. 교차 합치기
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < even.size() || j < odd.size()) {
            if (i < even.size()) result.add(even.get(i++));
            if (j < odd.size()) result.add(odd.get(j++));
        }

        // 6. 결과 배열로 변환
        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스 1
        int[] arr1 = {50, 98, 38, 11, 13, 90, 82, 83, 70};
        int[] result1 = sol.solution(arr1);
        System.out.println("입력: " + Arrays.toString(arr1));
        System.out.println("출력: " + Arrays.toString(result1));
        System.out.println("예상: [70, 82, 50, 83, 38, 90, 13, 98, 11]");
        System.out.println();

        // 테스트 케이스 2
        int[] arr2 = {3, -2, 8, 5, 3, 9};
        int[] result2 = sol.solution(arr2);
        System.out.println("입력: " + Arrays.toString(arr2));
        System.out.println("출력: " + Arrays.toString(result2));
        System.out.println("예상: [5, 8, 3, 9, -2]");
        System.out.println();

        // 테스트 케이스 3
        int[] arr3 = {3, 6, 7, 7, 2, 6, 0, -2, 6, -1, 13};
        int[] result3 = sol.solution(arr3);
        System.out.println("입력: " + Arrays.toString(arr3));
        System.out.println("출력: " + Arrays.toString(result3));
        System.out.println("예상: [2, 3, 0, 6, -1, 7, -2, 13]");
        System.out.println();

        // 테스트 케이스 4
        int[] arr4 = {};
        int[] result4 = sol.solution(arr4);
        System.out.println("입력: " + Arrays.toString(arr4));
        System.out.println("출력: " + Arrays.toString(result4));
        System.out.println("예상: []");
    }
}
