package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红马
 */
public final class RHorse extends Chessman {
    public static RHorse initLeft() {
        return new RHorse(Color.RED.val, 1, 11);
    }

    public static RHorse initRight() {
        return new RHorse(Color.RED.val, 7, 11);
    }

    private RHorse(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}