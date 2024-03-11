package org.wea4saken.algorithms.lecture1;

import java.util.Scanner;

public class PaintingTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();                      // индекс дерева, с которого начинает Вася
        int v = scanner.nextInt();                      // дистанция Васи
        int q = scanner.nextInt();                      // индекс дерева, с которого начинает Маша
        int m = scanner.nextInt();                      // дистанция Маши

        int countP = (p + v) - (p - v) + 1;             // сколько всего деревьев покрасит Вася + дерево P
        int countQ = (q + m) - (q - m) + 1;             // сколько всего деревьев покрасит Маша + дерево Q

        int crossedRange = Math.min(p + v, q + m) - Math.max(p - v, q - m) + 1;
        if (crossedRange < 0) crossedRange = 0;

        System.out.println(countP + countQ - crossedRange);

        scanner.close();
    }
}