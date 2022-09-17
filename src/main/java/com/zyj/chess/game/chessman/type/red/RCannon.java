package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红炮
 */
public final class RCannon extends Chessman {
    public static RCannon initLeft() {
        return new RCannon(Color.RED.val, 19, 11);
    }

    public static RCannon initRight() {
        return new RCannon(Color.RED.val, 25, 11);
    }

    private RCannon(int color, int index, int score) {
        super(color,index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}