package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigates;
import com.zyj.chess.game.params.Params;

import java.util.List;

/**
 * 黑士
 */
public final class BSquire extends Chessman {
    public BSquire(int y, int x) {
        super(4, x, y, 6, Navigates.NO_LIMIT);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
        list.addAll(Params.BLACK_SQUIRE_NAVIGATE.get(y * 10 + x));
    }
}