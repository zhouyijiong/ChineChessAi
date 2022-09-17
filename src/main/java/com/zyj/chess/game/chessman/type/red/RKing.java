package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 帥
 */
public final class RKing extends Chessman {
    public static RKing init() {
        return new RKing(Color.RED.val, 4, 100);
    }

    private RKing(int color, int index, int score) {
        super(color,index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}