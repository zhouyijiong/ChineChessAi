package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 黑炮
 */
public final class BCannon extends Chessman {
    public static BCannon initLeft() {
        return new BCannon(Color.BLACK.val, 64, 11);
    }

    public static BCannon initRight() {
        return new BCannon(Color.BLACK.val, 70, 11);
    }

    private BCannon(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}