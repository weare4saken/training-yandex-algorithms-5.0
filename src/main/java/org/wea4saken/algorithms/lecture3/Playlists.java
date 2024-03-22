package org.wea4saken.algorithms.lecture3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Playlists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean first = true;
        Set<String> result = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            int k = Integer.parseInt(scanner.nextLine());
            Set<String> tmp = new HashSet<>();

            for (int j = 0; j < k; ++j) {
                String sing = scanner.nextLine();

                if (first) {
                    result.add(sing);
                } else {
                    if (result.contains(sing)) {
                        tmp.add(sing);
                    }
                }
            }

            result = new HashSet<>(tmp);
            if (first) {
                first = false;
            }
        }

        System.out.println(result.size());
        for (String s : result) {
            System.out.print(s + " ");
        }

        scanner.close();
    }
}