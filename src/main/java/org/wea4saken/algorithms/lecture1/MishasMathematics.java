package session1;

import java.util.Scanner;

public class MishasMathematics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        long i1 = numbers[0];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            long i2 = numbers[i];
            if (i1 % 2 == 0 || i2 % 2 == 0) {
                sb.append('+');
                i1 += i2;
            } else {
                sb.append('x');
                i1 *= i2;
            }
        }

        System.out.println(sb);
    }
}