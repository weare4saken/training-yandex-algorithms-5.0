package org.wea4saken.algorithms.lecture3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeletingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer, Integer> digits = new HashMap<>();
        int digit;

        for (int i = 0; i < n; ++i) {
            digit = scanner.nextInt();
            digits.put(digit, digits.getOrDefault(digit, 0) + 1);
        }

        int maxCountValue = digits.entrySet().iterator().next().getKey();
        int maxCount = digits.entrySet().iterator().next().getValue();

        for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (digits.containsKey(value + 1)) {
                count += digits.get(value + 1);
            }

            if (count > maxCount) {
                maxCount = count;
                maxCountValue = value;
            }
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (value - maxCountValue == 1 || value == maxCountValue) {
                continue;
            }
            result += count;
        }

        System.out.println(result);
        scanner.close();
    }
}