package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 将
 */
public final class BKing extends Chessman {
    public static BKing init() {
        return new BKing(Color.BLACK.val, 85, 100);
    }

    private BKing(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}