package session1;

import java.util.Scanner;

public class FileFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] spacesToAdd = new int[n];

        for (int i = 0; i < n; i++) {
            spacesToAdd[i] = scanner.nextInt();
        }

        long totalKeyPresses = 0;

        for (int i = 0; i < n; i++) {
            if (spacesToAdd[i] == 0) {
                totalKeyPresses += 0;
            } else if (spacesToAdd[i] > 0 && spacesToAdd[i] < 4) {
                totalKeyPresses += (spacesToAdd[i] == 1) ? 1 : 2;
            } else {
                totalKeyPresses += (spacesToAdd[i] % 4 == 0) ? spacesToAdd[i] / 4 :
                        (spacesToAdd[i] % 4 == 1) ? spacesToAdd[i] / 4 + 1 : spacesToAdd[i] / 4 + 2;
            }
        }

        System.out.println(totalKeyPresses);

        scanner.close();
    }
}