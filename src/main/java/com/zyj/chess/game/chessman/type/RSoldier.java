package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;

import java.util.List;

/**
 * 红兵
 * 过河之后分数翻倍
 */
public final class RSoldier extends Chessman {
    public RSoldier(int y, int x) {
        super(17, x, y, 3);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
    }
}