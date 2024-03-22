package org.wea4saken.algorithms.lecture1;

import java.util.Scanner;

public class DestroyTheBarracks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soldiers = scanner.nextInt();
        int barracks = scanner.nextInt();
        int enemiesPerRound = scanner.nextInt();

        int minMoves = -1;
        int moveCount;
        int moveCount2 = 1;

        if (soldiers >= barracks) {
            System.out.println(1);
            return;
        }

        barracks -= soldiers;

        int enemies = enemiesPerRound;

        while (barracks > 0 && soldiers > 0) {
            moveCount = moveCount2;
            int[] count = {moveCount};

            if (calculateMinCountRounds(soldiers, barracks, enemies, count)) {
                if (minMoves == -1 || minMoves > count[0]) {
                    minMoves = count[0];
                }
                if (enemies == soldiers) {
                    System.out.println(minMoves);
                    return;
                }
            } else if (enemies == soldiers) {
                System.out.println(-1);
                return;
            }

            if (enemies > soldiers) {
                enemies -= soldiers;
                soldiers -= enemies;
            } else {
                barracks -= (soldiers - enemies);
                enemies = 0;
            }

            if (barracks > 0) {
                enemies += enemiesPerRound;
            }
            moveCount2 += 1;
        }

        System.out.println(minMoves);
    }

    public static boolean calculateMinCountRounds(int soldiers, int barracks, int enemies, int[] count) {
        while (barracks != 0 && soldiers > 0) {
            if (barracks > soldiers) {
                barracks -= soldiers;
                soldiers -= enemies;
            } else {
                enemies -= (soldiers - barracks);
                barracks = 0;
                soldiers -= enemies;
            }

            count[0] += 1;

            if (barracks > 0) {
                enemies += enemies;
            }
        }

        if (barracks == 0) {
            while (enemies > 0 && soldiers > 0) {
                enemies -= soldiers;
                if (enemies > 0) {
                    soldiers -= enemies;
                }
                count[0] += 1;
            }
            return soldiers > 0;
        } else {
            return false;
        }
    }
}