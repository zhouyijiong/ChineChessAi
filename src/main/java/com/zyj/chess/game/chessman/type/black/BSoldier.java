package com.zyj.chess.game.chessman.type.black;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.chessman.color.Color;

/**
 * 黑兵
 * 过河之后分数翻倍
 */
public final class BSoldier extends Chessman {
    public static BSoldier init1() {
        return new BSoldier(Color.BLACK.val, 54, 4);
    }

    public static BSoldier init2() {
        return new BSoldier(Color.BLACK.val, 56, 4);
    }

    public static BSoldier init3() {
        return new BSoldier(Color.BLACK.val, 58, 4);
    }

    public static BSoldier init4() {
        return new BSoldier(Color.BLACK.val,  60, 4);
    }

    public static BSoldier init5() {
        return new BSoldier(Color.BLACK.val, 62, 4);
    }

    private BSoldier(int color, int index, int score) {
        super(color,index, score);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }
}