package org.wea4saken.algorithms.lecture3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();

        if (makeMap(word1).equals(makeMap(word2))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    private static Map<Character, Integer> makeMap(String word) {
        Map<Character, Integer> result = new HashMap<>();

        for (char ch : word.toCharArray()) {
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }

        return result;
    }
}