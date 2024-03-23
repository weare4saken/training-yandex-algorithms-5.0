package org.wea4saken.algorithms.lecture3;

import java.util.*;

public class ReplacingWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] inputWords = inputLine.split("\\s+");

        Map<Integer, Set<String>> dictionary = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : inputWords) {
            int length = word.length();
            dictionary.computeIfAbsent(length, k -> new HashSet<>()).add(word);
        }

        inputLine = scanner.nextLine();
        String[] wordsToProcess = inputLine.split("\\s+");

        for (String word : wordsToProcess) {
            boolean found = false;

            for (int i = 1; i < word.length(); ++i) {
                String prefix = word.substring(0, i);

                if (dictionary.containsKey(i) && dictionary.get(i).contains(prefix)) {
                    result.add(prefix);
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(word);
            }
        }

        StringBuilder output = new StringBuilder();
        for (String s : result) {
            output.append(s).append(" ");
        }

        System.out.println(output.toString().trim());
        scanner.close();
    }
}