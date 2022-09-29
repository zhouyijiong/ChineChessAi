package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;

import java.util.List;

/**
 * 黑兵
 * 过河之后分数翻倍
 */
public final class BSoldier extends Chessman {
    public BSoldier(int y, int x) {
        super(7, x, y, 4);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
    }
}