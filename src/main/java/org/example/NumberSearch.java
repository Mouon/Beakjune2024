package org.example;

import java.util.*;


// 모름 어려움

public class NumberSearch {
    static Map<Character, Set<String>> numToSymbols = new HashMap<>();

    public static void main(String[] args) {
        numToSymbols.put('0', Set.of("0", "()"));
        numToSymbols.put('1', Set.of("I"));
        numToSymbols.put('2', Set.of("Z", "S", "7_"));
        numToSymbols.put('3', Set.of("E", "B"));
        numToSymbols.put('4', Set.of("A"));
        numToSymbols.put('5', Set.of("Z", "S"));
        numToSymbols.put('6', Set.of("b", "G"));
        numToSymbols.put('7', Set.of("T", "Y"));
        numToSymbols.put('8', Set.of("B", "E3"));
        numToSymbols.put('9', Set.of("g", "q"));

        String[] numstrs = {"ZASSETE","S4Z537B","7_ASZEYB"};
        String[] words = {"2455373", "425","373","378"};

        int[] result = matchCount(words,numstrs);
        System.out.println(Arrays.toString(result));

    }

    public static int[] matchCount(String[] words, String[] numstrs) {
        int[] result = new int[words.length];

        for (int l = 0; l < words.length; l++) {
            String word = words[l];
            int count = 0;
            int len = word.length();

            for (String numstr : numstrs) {

                for (int i = 0; i <= numstr.length() - len; i++) {
                    String subNumstr = numstr.substring(i, i + len);

                    if (isValidMapping(subNumstr, word)) {
                        count++;
                        break;
                    }
                }
            }

            result[l] = count;
        }

        return result;
    }

    public static boolean isValidMapping(String subNumstr, String word) {
        return backtrack(subNumstr, 0, word, 0, new HashMap<>(), new HashMap<>());
    }

    // 왜 안데냐
    public static boolean backtrack(String sub, int subIdx, String word, int wordIdx,
                                    Map<String, Character> symbolToNum, Map<Character, String> numToSymbol) {
        if (wordIdx == word.length() && subIdx == sub.length()) return true;
        if (wordIdx >= word.length() || subIdx >= sub.length()) return false;

        char digit = word.charAt(wordIdx);
        Set<String> candidates = numToSymbols.getOrDefault(digit, new HashSet<>());

        for (String symbol : candidates) {
            int len = symbol.length();

            if (subIdx + len > sub.length()) continue;
            String subSymbol = sub.substring(subIdx, subIdx + len);

            if (symbolToNum.containsKey(subSymbol) && symbolToNum.get(subSymbol) != digit) continue;
            if (numToSymbol.containsKey(digit) && !numToSymbol.get(digit).equals(subSymbol)) continue;

            symbolToNum.put(subSymbol, digit);
            numToSymbol.put(digit, subSymbol);

            if (backtrack(sub, subIdx + len, word, wordIdx + 1, symbolToNum, numToSymbol)) {
                return true;
            }

            symbolToNum.remove(subSymbol);
            numToSymbol.remove(digit);
        }

        return false;
    }


}
