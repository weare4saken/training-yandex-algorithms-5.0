package org.wea4saken.algorithms.lecture3;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;

public class TwoOutOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> result = new TreeSet<>();
        int value;

        int n = scanner.nextInt();
        Set<Integer> values1 = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            value = scanner.nextInt();
            values1.add(value);
        }

        n = scanner.nextInt();
        Set<Integer> values2 = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            value = scanner.nextInt();
            values2.add(value);

            if (values1.contains(value)) {
                result.add(value);
            }
        }

        n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            value = scanner.nextInt();
            if (values1.contains(value) || values2.contains(value)) {
                result.add(value);
            }
        }

        for (int item : result) {
            System.out.print(item + " ");
        }

        scanner.close();
    }
}