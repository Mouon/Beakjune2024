package org.example;

import java.util.Arrays;

/**
 * 모든 경우 수는 dfs 도 방법이다. 
 * */
public class ProImo {

    static class Solution {
        static int[] discountRates = {10, 20, 30, 40};
        static int maxSubscribers = 0, maxRevenue = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] discounts = new int[emoticons.length];
            dfs(0, users, emoticons, discounts);
            return new int[]{maxSubscribers, maxRevenue};
        }

        private void dfs(int depth, int[][] users, int[] emoticons, int[] discounts) {
            if (depth == emoticons.length) {
                calculate(users, emoticons, discounts);
                return;
            }

            // 각 이모티콘에 대해 10%, 20%, 30%, 40% 중 하나 적용
            for (int discount : discountRates) {
                discounts[depth] = discount;
                dfs(depth + 1, users, emoticons, discounts);
            }
        }

        private void calculate(int[][] users, int[] emoticons, int[] discounts) {
            int totalSubscribers = 0;
            int totalRevenue = 0;

            for (int[] user : users) {
                int userThreshold = user[0];
                int userBudget = user[1];
                int totalPrice = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= userThreshold) {
                        totalPrice += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }

                if (totalPrice >= userBudget) {
                    totalSubscribers++;
                } else {
                    totalRevenue += totalPrice;
                }
            }

            if (totalSubscribers > maxSubscribers ||
                    (totalSubscribers == maxSubscribers && totalRevenue > maxRevenue)) {
                maxSubscribers = totalSubscribers;
                maxRevenue = totalRevenue;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] users1 = {{40, 10000}, {25, 10000}};
        int[] emoticons1 = {7000, 9000};
        System.out.println("Test Case 1: " + Arrays.toString(solution.solution(users1, emoticons1)));

        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};
        System.out.println("Test Case 2: " + Arrays.toString(solution.solution(users2, emoticons2)));
    }
}
