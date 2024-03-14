package org.wea4saken.algorithms.lecture2;

import java.util.*;

public class FishSeller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            prices.add(price);
        }
        prices.add(-1);                 // отрицательной цены не может быть
                                        // неоходимо, чтоб выйти из цикла

        int profit = 0;
        int today = 0;

        while (true) {
            int buyPrice = prices.get(today);
            if (buyPrice == -1) break;

            int plusRottingDay = 1;

            while (plusRottingDay <= k) {
                int soldPrice = prices.get(today + plusRottingDay);
                if (soldPrice == -1) break;

                int potentialProfit = soldPrice - buyPrice;
                if (potentialProfit > profit) profit = potentialProfit;

                ++plusRottingDay;
            }
            ++today;
        }
        System.out.println(profit);
        scanner.close();
    }
}