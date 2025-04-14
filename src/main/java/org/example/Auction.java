package org.example;

import java.util.*;

public class Auction {

    public int[] solution(int n, int[] amounts) {
        int[] answer = new int[n];
        int maxA = amounts.length - 1;
        for (int i = 0; i < n; i++) {
            Arrays.sort(amounts);
            int spendMoney = 0;
            if (amounts[maxA] == amounts[maxA - 1]) {
                spendMoney = amounts[maxA];
                answer[i] = spendMoney;
                amounts[maxA] -= spendMoney;

            } else if (amounts[maxA] != 0) {
                spendMoney = amounts[maxA - 1] + 10000;
                answer[i] = spendMoney;
                amounts[maxA] -= spendMoney;
            } else {
                answer[i] = spendMoney;
            }
        }
        return answer;
    }
}



