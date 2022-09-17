package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红士
 */
public final class RSquire extends Chessman {
    public static RSquire initLeft() {
        return new RSquire(Color.RED.val, 3, 6);
    }

    public static RSquire initRight() {
        return new RSquire(Color.RED.val, 5, 6);
    }

    private RSquire(int color, int index, int score) {
        super(color,index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}