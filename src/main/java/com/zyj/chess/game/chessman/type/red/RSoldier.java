package com.zyj.chess.game.chessman.type.red;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 红兵
 * 过河之后分数翻倍
 */
public final class RSoldier extends Chessman {
    public static RSoldier init1() {
        return new RSoldier(Color.RED.val, 27, 4);
    }

    public static RSoldier init2() {
        return new RSoldier(Color.RED.val, 29, 4);
    }

    public static RSoldier init3() {
        return new RSoldier(Color.RED.val, 31, 4);
    }

    public static RSoldier init4() {
        return new RSoldier(Color.RED.val, 33, 4);
    }

    public static RSoldier init5() {
        return new RSoldier(Color.RED.val, 35, 4);
    }

    private RSoldier(int color, int index, int score) {
        super(color, index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}