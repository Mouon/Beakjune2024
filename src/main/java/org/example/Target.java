package org.example;

import java.util.Scanner;

public class Target {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Solution solution = new Solution();
        int target = scan.nextInt();
        int[] numbers = {1, 1, 1, 1,1};
        System.out.println(solution.solution(numbers, target));

    }
    static class Solution {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(0, numbers, target, 0);
            return answer;
        }

        private void dfs(int depth, int[] numbers, int target, int sum) {
            if (depth == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }
            dfs(depth + 1, numbers, target, sum + numbers[depth]);
            dfs(depth + 1, numbers, target, sum - numbers[depth]);
        }
    }
}
