package org.enigmacamp;

import java.util.*;

import java.util.*;

public class LetterCounter {

    public static void main(String[] args) {
        String[] data1 = {"Abc", "bCd"};
        String[] data2 = {"Oke", "One"};
        String[] data3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

        System.out.println(groupAndSortCharacters(data1)); // Output: bACcd
        System.out.println(groupAndSortCharacters(data2)); // Output: Oekn
        System.out.println(groupAndSortCharacters(data3)); // Output: aenrktiBDPTUdimu
    }

    private static String groupAndSortCharacters(String[] data) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (String word : data) {
            for (char c : word.toCharArray()) {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }

        List<Character> sortedChars = new ArrayList<>(charCounts.keySet());
        sortedChars.sort((c1, c2) -> {
            int countComparison = Integer.compare(charCounts.get(c2), charCounts.get(c1));
            if (countComparison == 0) {
                return Character.compare(c1, c2);
            }
            return countComparison;
        });

        StringBuilder groupedAndSortedCharsBuilder = new StringBuilder();
        for (char c : sortedChars) {
            groupedAndSortedCharsBuilder.append(c);
        }
        return groupedAndSortedCharsBuilder.toString();
    }
}

