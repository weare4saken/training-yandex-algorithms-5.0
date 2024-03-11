package session1;

import java.util.Scanner;

public class FootballCommentator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String totalScoreMatch1 = scanner.nextLine();                  // формат счёта 0:1 МАТЧ 1: 0 - 1-ая команда, 1 - 2-ая команда
        String totalScoreMatch2 = scanner.nextLine();                  // формат счёта 0:1 МАТЧ 2: 0 - 1-ая команда, 1 - 2-ая команда
        int atHomeOrAway = scanner.nextInt();                          // 1-ая команда играет: 1 - дома, 2 - в гостях

        String[] scorePartsMatch1 = totalScoreMatch1.split(":");
        String[] scorePartsMatch2 = totalScoreMatch2.split(":");

        int scoreFirstMatch1 = Integer.parseInt(scorePartsMatch1[0]);  // кол-во голов 1-ой команды в 1-ом матче
        int scoreFirstMatch2 = Integer.parseInt(scorePartsMatch2[0]);  // кол-во голов 1-ой команды во 2-ом матче
        int scoreSecondMatch1 = Integer.parseInt(scorePartsMatch1[1]); // кол-во голов 2-ой команды в 1-ом матче
        int scoreSecondMatch2 = Integer.parseInt(scorePartsMatch2[1]); // кол-во голов 2-ой команды во 2-ом матче

        int totalScoreFirst = scoreFirstMatch1 + scoreFirstMatch2;     // общее кол-во голов 1-ой команды в 2-ух матчах
        int totalScoreSecond = scoreSecondMatch1 + scoreSecondMatch2;  // общее кол-во голов 2-ой команды в 2-ух матчах

        int goalsToWin = 0;

        if (totalScoreFirst > totalScoreSecond) {
            System.out.println(goalsToWin);
        } else if (totalScoreFirst == totalScoreSecond) {
            if (atHomeOrAway == 1) {
                goalsToWin = scoreFirstMatch2 <= scoreSecondMatch1 ? 1 : 0;
            } else {
                goalsToWin = scoreFirstMatch1 <= scoreSecondMatch2 ? 1 : 0;
            }
            System.out.println(goalsToWin);
        } else {
            if (atHomeOrAway == 1) {
                goalsToWin = totalScoreSecond - totalScoreFirst;
                if ((goalsToWin == scoreSecondMatch1 && scoreFirstMatch2 != scoreSecondMatch1
                        && scoreFirstMatch2 + goalsToWin <= scoreSecondMatch1)
                        || (goalsToWin < scoreSecondMatch1 && scoreFirstMatch2 != scoreSecondMatch1
                        && scoreFirstMatch2 + goalsToWin <= scoreSecondMatch1)) {
                    goalsToWin += 1;
                }
            } else {
                goalsToWin = totalScoreSecond - totalScoreFirst;
                if (goalsToWin >= scoreSecondMatch1 || scoreFirstMatch1 <= scoreSecondMatch2) {
                    goalsToWin = totalScoreSecond - totalScoreFirst + 1;
                }
            }
            System.out.println(goalsToWin);
        }

        scanner.close();
    }
}