package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 黑象
 */
public final class BElephant extends Chessman {
    public static BElephant initLeft() {
        return new BElephant(Color.BLACK.val, 83, 6);
    }

    public static BElephant initRight() {
        return new BElephant(Color.BLACK.val, 87, 6);
    }

    private BElephant(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}