package org.wea4saken.algorithms.lecture2;

import java.util.Scanner;

public class MinimumRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int x;
        int y;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        boolean isFirst = true;

        for (int i = 0; i < k; ++i) {
            x = scanner.nextInt();
            y = scanner.nextInt();

            if (isFirst) {
                minX = x;
                maxX = x;
                minY = y;
                maxY = y;
                isFirst = false;
            } else {
                maxX = Math.max(x, maxX);
                minX = Math.min(x, minX);
                maxY = Math.max(y, maxY);
                minY = Math.min(y, minY);
            }
        }

        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        scanner.close();
    }
}