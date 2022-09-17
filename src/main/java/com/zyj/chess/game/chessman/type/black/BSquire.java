package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

public final class BSquire extends Chessman {
    public static BSquire initLeft() {
        return new BSquire(Color.BLACK.val, 84, 6);
    }

    public static BSquire initRight() {
        return new BSquire(Color.BLACK.val, 86, 6);
    }

    private BSquire(int color, int index, int score) {
        super(color,index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}