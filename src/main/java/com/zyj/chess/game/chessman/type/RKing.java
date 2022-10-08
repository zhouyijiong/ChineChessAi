package com.zyj.chess.game.chessman.type;

import com.zyj.chess.game.chessman.Chessman;
import com.zyj.chess.game.params.Navigates;

import java.util.List;

/**
 * 红帅
 */
public final class RKing extends Chessman {
    public RKing(int y, int x) {
        super(15, x, y, 100, Navigates.NO_LIMIT);
    }

    @Override
    public int calcDangerScore(Chessman[] board, int... params) {
        return 0;
    }

    @Override
    public void navigate(List<Integer> list) {
    }
}