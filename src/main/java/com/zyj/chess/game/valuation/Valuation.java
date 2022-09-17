package com.zyj.chess.game.valuation;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;
import com.zyj.chess.game.chessman.type.red.RCar;
import com.zyj.chess.game.chessman.type.red.RSoldier;
import com.zyj.chess.game.params.Params;

public final class Valuation {
    public final Chessman[] board;
    public final Chessman[][] chessmen;

    public Valuation(Chessman[] board, Chessman[][] chessmen) {
        this.board = board;
        this.chessmen = chessmen;
    }

    public int checkBlack() {
//        int redScore = calcChessmenScore(Color.RED.val);
//        int blackScore = calcChessmenScore(Color.BLACK.val);
//        int index = chessmen[0][4].getIndex();
//        int chessId;
//        Chessman chessman;
//        for (int i : Params.BLACK_KING_AROUND) {
//            if ((chessman = board[index + i]) != null && chessman.getColor() == Color.RED.val) {
//                chessId = chessman.getId();
//                redScore += (chessId == RCar.ID || chessId == RSoldier.ID) ? 0xff : 30;
//            }
//        }
//        if (index < 78 && (chessman = board[index - 9]) != null && chessman.getColor() == Color.RED.val) {
//            chessId = chessman.getId();
//            redScore += chessId == RCar.ID ? 0xff : 10;
//        }
//        return blackScore - redScore;
        return 0;
    }

    public int checkRed() {
        return 0;
    }

    public int calcBlackDangerScore() {
        int score = 0;
        for (Chessman chessmen : chessmen[Color.RED.val]) {
            if (chessmen == null) continue;
            chessmen.calcDangerScore(null, 0);
            score++;
        }
        return score;
    }

    public int calcChessmenScore(int color) {
        int score = 0;
        for (Chessman chessman : chessmen[color]) {
            score += chessman.getScore();
        }
        return score;
    }
}