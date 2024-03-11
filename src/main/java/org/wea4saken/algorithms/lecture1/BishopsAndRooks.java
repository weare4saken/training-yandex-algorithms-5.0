package org.wea4saken.algorithms.lecture1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BishopsAndRooks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessBoard = new char[8][8];

        for (int i = 0; i < 8; i++) {
            chessBoard[i] = scanner.next().toCharArray();
        }

        List<int[]> rooks = new ArrayList<>();
        List<int[]> bishops = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == 'R') {
                    rooks.add(new int[]{i, j});
                    chessBoard[i][j] = 'F';
                } else if (chessBoard[i][j] == 'B') {
                    bishops.add(new int[]{i, j});
                    chessBoard[i][j] = 'F';
                }
            }
        }

        for (int[] rook : rooks) {
            rook(chessBoard, rook[0], rook[1]);
        }

        for (int[] bishop : bishops) {
            bishop(chessBoard, bishop[0], bishop[1]);
        }

        for (char[] row : chessBoard) {
            for (char cell : row) {
                if (cell == '*') {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void rook(char[][] chessBoard, int x, int y) {
        for (int i = 1; i < 8; i++) {
            try {
                if (chessBoard[x + i][y] != 'F') {
                    chessBoard[x + i][y] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            try {
                if (chessBoard[x][y + i] != 'F') {
                    chessBoard[x][y + i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            try {
                if (chessBoard[x - i][y] != 'F' && x - i > -1) {
                    chessBoard[x - i][y] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            try {
                if (chessBoard[x][y - i] != 'F' && y - i > -1) {
                    chessBoard[x][y - i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static void bishop(char[][] chessBoard, int x, int y) {
        for (int i = 1; i < 9; i++) {
            try {
                if (x - i > -1 && y - i > -1 && chessBoard[x - i][y - i] != 'F') {
                    chessBoard[x - i][y - i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 9; i++) {
            try {
                if (x - i > -1 && chessBoard[x - i][y + i] != 'F') {
                    chessBoard[x - i][y + i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 9; i++) {
            try {
                if (y - i > -1 && chessBoard[x + i][y - i] != 'F') {
                    chessBoard[x + i][y - i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 1; i < 9; i++) {
            try {
                if (chessBoard[x + i][y + i] != 'F') {
                    chessBoard[x + i][y + i] = '.';
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }
}