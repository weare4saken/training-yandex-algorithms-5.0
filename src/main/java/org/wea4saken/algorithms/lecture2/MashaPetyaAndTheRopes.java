package org.wea4saken.algorithms.lecture2;

import java.util.Scanner;

public class MashaPetyaAndTheRopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] remainingRopes = new int[n];

        for (int i = 0; i < n; i++) {
            remainingRopes[i] = scanner.nextInt();
        }

        boolean isFirst = true;
        int sumRopesLength = 0;
        int maxRopeLength = 0;

        for(int i = 0; i < n; ++i) {
            int currentRopeLength = remainingRopes[i];

            sumRopesLength += currentRopeLength;

            if (isFirst) {
                maxRopeLength += currentRopeLength;
                isFirst = false;
            } else {
                maxRopeLength = Math.max(maxRopeLength, currentRopeLength);
            }
        }

        int takenRopeLength = 0;

        if (maxRopeLength * 2 > sumRopesLength) takenRopeLength = maxRopeLength * 2 - sumRopesLength;
        else takenRopeLength = sumRopesLength;

        System.out.println(takenRopeLength);
        scanner.close();
    }
}