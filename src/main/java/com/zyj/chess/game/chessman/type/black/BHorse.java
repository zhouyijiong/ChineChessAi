package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 黑马
 */
public final class BHorse extends Chessman {
    public static BHorse initLeft() {
        return new BHorse(Color.BLACK.val, 82, 11);
    }

    public static BHorse initRight() {
        return new BHorse(Color.BLACK.val, 88, 11);
    }

    private BHorse(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}