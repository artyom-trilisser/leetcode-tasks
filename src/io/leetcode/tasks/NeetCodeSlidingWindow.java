package io.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NeetCodeSlidingWindow {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minIndex = 0;
        int maxIndex = 0;

        while (maxIndex < prices.length) {
            if (prices[minIndex] > prices[maxIndex]) {
                minIndex = maxIndex;
            } else {
                if (maxProfit < (prices[maxIndex] - prices[minIndex])) {
                    maxProfit = prices[maxIndex] - prices[minIndex];
                }
            }

            maxIndex++;
        }
        return maxProfit;
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '{', '[', '(' -> stack.push(ch);
                case '}', ']', ')' -> {
                    if (stack.empty()) return false;

                    var fromStack = stack.pop();

                    if (map.get(fromStack) != ch) return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * 567. Permutation in String
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     * In other words, return true if one of s1's permutations is the substring of s2.
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int i1 = s1.charAt(i) - 'a';
            int i2 = s2.charAt(i) - 'a';
            s1Count[i1]++;
            s2Count[i2]++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] + 1 == s2Count[index])
                matches--;

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] - 1 == s2Count[index])
                matches--;

            l++;
        }
        return matches == 26;
    }

    /**
     * 76. Minimum Window Substring
     * Hard
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     */
//    public String minWindow(String s, String t) {
//
//    }




}

