package org.wea4saken.algorithms.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmbitiousSnail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int a, b;
        List<Integer> lift = new ArrayList<>();
        List<Integer> downhill = new ArrayList<>();

        int maxA = 0;
        int maxAIndex = -1;
        int maxB = 0;
        int maxBIndex = -1;
        boolean firstPositive = true;
        boolean firstNegative = true;

        List<Integer> vectorA = new ArrayList<>();
        List<Integer> vectorB = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            vectorA.add(a);
            vectorB.add(b);

            int delta = a - b;

            if (delta <= 0) {
                if (firstNegative) {
                    firstNegative = false;
                    maxA = a;
                    maxAIndex = i;
                } else {
                    if (maxA < a) {
                        maxA = a;
                        maxAIndex = i;
                    }
                }
                downhill.add(i);
            } else {
                if (firstPositive) {
                    firstPositive = false;
                    maxB = b;
                    maxBIndex = i;
                } else {
                    if (maxB < b) {
                        maxB = b;
                        maxBIndex = i;
                    }
                }
                lift.add(i);
            }
        }

        long current = 0;
        long maxValue = 0;

        if (!lift.isEmpty()) {
            for (int index : lift) {
                if (index == maxBIndex) continue;
                if (maxValue < current + vectorA.get(index)) {
                    maxValue = current + vectorA.get(index);
                }
                current += vectorA.get(index) - vectorB.get(index);
            }

            if (maxValue < current + vectorA.get(maxBIndex)) {
                maxValue = current + vectorA.get(maxBIndex);
            }
            current += vectorA.get(maxBIndex) - vectorB.get(maxBIndex);
        }
        if (maxAIndex != -1) {
            if (maxValue < current + vectorA.get(maxAIndex)) {
                maxValue = current + vectorA.get(maxAIndex);
            }
        }

        System.out.println(maxValue);
        if (!lift.isEmpty()) {
            for (int index : lift) {
                if (index == maxBIndex) continue;
                System.out.print((index + 1) + " ");
            }
            System.out.print((maxBIndex + 1) + " ");
        }


        if (!downhill.isEmpty()) {
            System.out.print((maxAIndex + 1) + " ");
            for (int index : downhill) {
                if (index == maxAIndex) continue;
                System.out.print((index + 1) + " ");
            }
        }

        scanner.close();
    }
}