package org.wea4saken.algorithms.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoMoreNoLess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tests = 0; tests < t; ++tests) {
            int n = scanner.nextInt();
            int count = 0;
            List<Integer> segments = new ArrayList<>();
            int currentLength = 0;
            int maxLength = 0;
            boolean first = true;
            for (int i = 0; i < n; ++i) {
                int value = scanner.nextInt();
                if (first) {
                    maxLength = value;
                    currentLength = 1;
                    first = false;
                } else {
                    if (value < currentLength + 1) {
                        segments.add(currentLength);
                        ++count;
                        maxLength = value;
                        currentLength = 1;
                    } else {
                        ++currentLength;
                        if (maxLength > value) {
                            maxLength = value;
                        }
                    }
                }
                if (currentLength >= maxLength) {
                    segments.add(currentLength);
                    ++count;
                    first = true;
                }
            }

            if (!first && currentLength >= 1) {
                segments.add(currentLength);
                ++count;
            }
            System.out.println(count);
            for (int length : segments) {
                System.out.print(length + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
