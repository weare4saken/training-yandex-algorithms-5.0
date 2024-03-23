package org.wea4saken.algorithms.lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DeletingNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        Map<Integer, Integer> digits = new HashMap<>();
        String[] numbers = reader.readLine().trim().split("\\s+");

        for (int i = 0; i < n; ++i) {
            int digit = Integer.parseInt(numbers[i]);
            digits.put(digit, digits.getOrDefault(digit, 0) + 1);
        }

        int maxCountValue = 0;
        int maxCount = 0;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            int nextValueCount = digits.getOrDefault(value + 1, 0);
            count += nextValueCount;

            if (count > maxCount) {
                maxCount = count;
                maxCountValue = value;
            }
        }

        for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (value - maxCountValue != 1 && value != maxCountValue) {
                result += count;
            }
        }

        System.out.println(result);
        reader.close();
    }
}