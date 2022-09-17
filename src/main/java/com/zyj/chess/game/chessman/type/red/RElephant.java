package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红象
 */
public final class RElephant extends Chessman {
    public static RElephant initLeft() {
        return new RElephant(Color.RED.val, 2, 6);
    }

    public static RElephant initRight() {
        return new RElephant(Color.RED.val, 6, 6);
    }

    private RElephant(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}