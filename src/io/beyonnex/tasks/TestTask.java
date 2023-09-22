package io.beyonnex.tasks;

import java.util.HashMap;
import java.util.Map;

public class TestTask {
    /*
     * Since we don't have any restrictions of the alphabet used in str1 and str2
     * I suppose using a HashMap for "counting" the characters in the given strings.
     * The case with using alphabetical characters only is written below this method
     */
    public boolean areAnagrams(String str1, String str2) {

        if (str1.equals(str2)) {
            return true;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            final var key = str1.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            final var key = str2.charAt(i);
            if (!map.containsKey(key)) {
                return false;
            } else {
                var count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, --count);
                }
            }
        }

        return true;
    }

    /*
    * Case when the alphabet restricted by using alphabetical characters only
    * */
    public boolean areAlphabeticalAnagrams(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        if (str1.length() != str2.length())
            return false;

        int[] charsConter = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            charsConter[str1.charAt(i) - 'a']++;
            charsConter[str2.charAt(i) - 'a']--;
        }

        for (int n : charsConter)
            if (n != 0) return false;

        return true;
    }
}
