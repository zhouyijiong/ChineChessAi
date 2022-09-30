package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 红士
 */
public final class RSquire extends Chessman {
    public RSquire(int y, int x) {
        super(14, x, y, 6);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        list.addAll(Params.RED_SQUIRE_NAVIGATE.get(y * 10 + x));
    }
}