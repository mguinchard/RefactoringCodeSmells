package com.example.refactoringcodesmells;

import org.apache.commons.lang3.StringUtils;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;

    public void wonPoint(String playerName) {
        if (StringUtils.equals(playerName, "player1")) {
            mScore1 = mScore1 + 1;
        } else {
            mScore2 = mScore2 + 1;
        }
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (mScore1 == mScore2) {
            String scoreTmp = switch (mScore1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
            score.append(scoreTmp);
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) score.append("Advantage player1");
            else if (minusResult == -1) score.append("Advantage player2");
            else if (minusResult >= 2) score.append("Win for player1");
            else score.append("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = mScore1;
                } else {
                    score.append("-");
                    tempScore = mScore2;
                }

                String text = switch (tempScore) {
                    case 0 -> "Love";
                    case 1 -> "Fifteen";
                    case 2 -> "Thirty";
                    default -> "Forty";
                };
                score.append(text);
            }
        }
        return score.toString();
    }
}
