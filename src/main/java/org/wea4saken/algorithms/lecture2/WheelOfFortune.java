package org.wea4saken.algorithms.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WheelOfFortune {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();

        int maxValue = 0;
        boolean isFirst = true;

        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int value = scanner.nextInt();
            if (isFirst) {
                isFirst = false;
                maxValue = value;
            } else {
                maxValue = Math.max(value, maxValue);
            }
            values.add(value);
        }

        int startOffset = a / k;
        if (a <= k * startOffset) {
            --startOffset;
        }

        int finishOffset = b / k;
        if (b <= k * finishOffset) {
            --finishOffset;
        }

        if (finishOffset - startOffset >= n) {
            System.out.println(maxValue);
            return;
        }

        isFirst = true;
        int startPosition = startOffset % n;
        int steps = 0;

        while (steps < n) {
            int index = (startPosition + steps) % n;

            int reverseIndex = n - (startPosition + steps);
            if (reverseIndex < 0) {
                reverseIndex += n;
            }
            reverseIndex %= n;

            int value = values.get(index);
            int reverseValue = values.get(reverseIndex);

            if (isFirst) {
                maxValue = Math.max(value, reverseValue);
                isFirst = false;
            } else {
                maxValue = Math.max(maxValue, Math.max(value, reverseValue));
            }
            ++steps;
            if (steps > finishOffset - startOffset) break;
        }

        System.out.println(maxValue);
    }
}