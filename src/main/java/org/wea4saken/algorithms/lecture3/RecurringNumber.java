package org.wea4saken.algorithms.lecture3;

import java.util.*;

public class RecurringNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> interval = new LinkedList<>();
        Set<Integer> values = new HashSet<>();

        boolean result = false;

        for (int i = 0; i < n; ++i) {
            int value = scanner.nextInt();
            if (result) continue;

            if (values.contains(value)) {
                result = true;
                continue;
            }

            if (interval.size() >= k) {
                int front = interval.poll();
                values.remove(front);
            }

            interval.offer(value);
            values.add(value);
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}