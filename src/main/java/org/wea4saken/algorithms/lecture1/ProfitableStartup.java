package session1;

import java.util.Scanner;

public class ProfitableStartup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbers = line.split("\\s+");

        long n = Long.parseLong(numbers[0]);
        long k = Long.parseLong(numbers[1]);
        long d = Long.parseLong(numbers[2]);

        n = n * 10;
        for (int i = 0; i < 10; i++) {
            if ((n + i) % k == 0) {
                n += i;
                System.out.println(n + "0".repeat((int) d - 1));
                return;
            }
        }
        System.out.println(-1);
    }
}