package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑车
 */
public final class BCar extends Chessman {
    public static BCar initLeft() {
        return new BCar(Color.BLACK.val, 81, 23);
    }

    public static BCar initRight() {
        return new BCar(Color.BLACK.val, 89, 23);
    }

    private BCar(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        List<Integer> point = Params.BLACK_CAR_NAVIGATE.get(index);
        int score = 0;
        for (int i = 0, len = point.size(); i < len; ++i) {
            if (board[i] == null || board[i].getColor() == Color.BLACK.val) continue;
            int y = i / 9;
            int x = i % 9;
            ++score;
        }
        return score;
    }
}