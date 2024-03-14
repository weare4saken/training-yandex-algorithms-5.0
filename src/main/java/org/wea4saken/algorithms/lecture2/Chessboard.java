package org.wea4saken.algorithms.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chessboard {
    public static void main(String[] args) {
        List<List<Integer>> board = new ArrayList<>();
        int size = 10;

        for (int i = 0; i < size; ++i) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < size; ++j) {
                line.add(-1);
            }
            board.add(line);
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Pair<Integer, Integer>> points = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board.get(x).set(y, 0);
            points.add(new Pair<>(x, y));
        }

        int perimeter = getPerimeter(points, board);

        System.out.println(perimeter);
        scanner.close();
    }

    private static int getPerimeter(List<Pair<Integer, Integer>> points, List<List<Integer>> board) {
        ArrayList<Integer> dx = new ArrayList<>(4);
        dx.add(0);
        dx.add(1);
        dx.add(0);
        dx.add(-1);
        ArrayList<Integer> dy = new ArrayList<>(4);
        dy.add(1);
        dy.add(0);
        dy.add(-1);
        dy.add(0);

        int perimeter = 0;
        for (Pair<Integer, Integer> xy : points) {
            int x = xy.getKey();
            int y = xy.getValue();
            for (int i = 0; i < dx.size(); ++i) {
                if (board.get(x + dx.get(i)).get(y + dy.get(i)) == -1) {
                    ++perimeter;
                }
            }
        }
        return perimeter;
    }

    static class Pair<T, R> {
        private final T key;
        private final R value;

        public Pair(T key, R value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public R getValue() {
            return value;
        }
    }
}